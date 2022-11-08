package linked_list.linked_list_cycle;

import linked_list.common.ListNode;
import linked_list.common.ListNodeFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class Solution {

    private static Set<ListNode> listNodeSet = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        while (p != null) {
            if (listNodeSet.contains(p)) {
                return true;
            }
            listNodeSet.add(p);
            p = p.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNodeFactory.generateListNode(1, 2, 3, 4);
        listNode.next.next.next.next = listNode.next;
        System.out.println(new Solution().hasCycle(listNode));
    }
}