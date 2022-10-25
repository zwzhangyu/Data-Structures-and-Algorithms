package linked_list.common;


/**
 * 链表工厂
 *
 * @author zhangyu
 * @date 2022/10/25
 **/
public class ListNodeFactory {


    /**
     * 根据输入int可变参数生成链表结构
     */
    public static ListNode generateListNode(int... args) {
        ListNode listNode = new ListNode(args[0]);
        ListNode head = listNode;
        for (int i = 1; i < args.length; i++) {
            listNode.next = new ListNode(args[i]);
            listNode = listNode.next;
        }
        return head;
    }


}
