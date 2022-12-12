package queue.fifo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 先入先出队列
 *
 * @author zhangyu
 * @date 2022/12/12
 **/
public class Main {
    public static void main(String[] args) {
        // 使用LinkedList创建一个队列
        Queue queue = new LinkedList<String>();
        queue.add("First");
        queue.add("Second");
        queue.add("third");
        System.out.println("构建队列 " + queue);
        // 移除队列第一个元素
        String value = (String) queue.remove();
        System.out.println("移除队列头部元素: " + value);
        System.out.println("当前队列数据: " + queue);
        // 查询队列头部元素但是不移除
        String head = (String) queue.peek();
        System.out.println("查询队列头部元素: " + head);
        int size = queue.size();
        System.out.println("当前队列大小: " + size);
        System.out.println("当前队列元素: " + queue);
    }
}
