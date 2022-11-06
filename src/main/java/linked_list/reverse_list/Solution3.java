package linked_list.reverse_list;

import linked_list.common.ListNode;
import linked_list.common.ListNodeFactory;

public class Solution3 {

    /**
     * 递归解法
     */
    public ListNode reverseList(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeFactory.generateListNode(2, 3, 4);
        ListNodeFactory.print(listNode);
        ListNode listNode1 = new Solution3().reverseList(listNode);
        ListNodeFactory.print(listNode1);
    }


}


