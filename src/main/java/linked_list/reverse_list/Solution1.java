package linked_list.reverse_list;

import linked_list.common.ListNode;
import linked_list.common.ListNodeFactory;

import java.util.LinkedList;

public class Solution1 {

    private final LinkedList<ListNode> stack = new LinkedList<>();

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode p = stack.pollLast();
        ListNode pHead = p;
        while ((p.next = stack.pollLast()) != null) {
            p = p.next;
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeFactory.generateListNode(2, 3);
        ListNodeFactory.print(listNode);
        ListNode listNode1 = new Solution1().reverseList(listNode);
        ListNodeFactory.print(listNode1);
    }


}


