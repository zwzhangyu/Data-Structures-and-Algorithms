package linked_list.k_th_from_end;


import linked_list.common.ListNode;
import linked_list.common.ListNodeFactory;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 力扣（LeetCode）  https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * @author zhangyu
 * @date 2022/10/25
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 快指针
        ListNode fastK = head;
        // 慢指针
        ListNode slow = head;
        // 快指针先走K步
        for (int i = 0; i < k; i++) {
            if (fastK == null) return null;
            fastK = fastK.next;
        }
        // 快慢指针同步走，直到尾部结束
        while (fastK != null) {
            slow = slow.next;
            fastK = fastK.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeFactory.generateListNode(1, 2, 3, 4, 5, 6);
        ListNode kthFromEnd = new Solution().getKthFromEnd(listNode, 4);
        System.out.println(kthFromEnd.val);
    }
}


