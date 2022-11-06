package linked_list.reverse_list;

import linked_list.common.ListNode;
import linked_list.common.ListNodeFactory;

public class Solution2 {

    /**
     * 双指针迭代解法
     */
    public ListNode reverseList(ListNode head) {
        // 前一个节点
        ListNode prev = null;
        // 当前节点
        ListNode curr = head;
        // 当前节点不为空
        while (curr != null) {
            // 先保存当前处理节点，即下一个节点
            ListNode next = curr.next;
            // curr的next反转指向上一个节点
            curr.next = prev;
            // 双节点顺移到下一个节点
            prev = curr;
            curr = next;
        }
        // 返回的是prev，此时curr是null
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeFactory.generateListNode(2, 3, 4);
        ListNodeFactory.print(listNode);
        ListNode listNode1 = new Solution2().reverseList(listNode);
        ListNodeFactory.print(listNode1);
    }


}


