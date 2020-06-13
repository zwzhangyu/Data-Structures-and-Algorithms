package leetcode.$2两数相加;

/**
 * @Author zhangyu
 * @Date 2020/6/6
 * @Description
 **/
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode current = new ListNode(0);
        ListNode result = current;
        int carry = 0;

        while (p1 != null || p2 != null) {
            //获取第一个链表的当前数字
            int a = (p1 != null) ? p1.val : 0;
            //获取第二个链表的当前数字
            int b = (p2 != null) ? p2.val : 0;
            //获取当前加法运算总数
            int sum = a + b + carry;
            //更新进位值carry
            carry = sum / 10;
            //链接结果链表
            current.next = new ListNode(sum % 10);
            //更新指针
            current = current.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;

        }
        //处理最高位的进位
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }

    /**
     * (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(6);
        ListNode p6 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p4.next = p5;
        p5.next = p6;
        ListNode listNode = new Solution().addTwoNumbers(p1, p4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
