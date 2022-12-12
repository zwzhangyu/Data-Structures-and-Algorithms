package queue.priority_queue;

import org.testng.annotations.Test;

import java.text.Collator;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先级队列
 *
 * @author zhangyu
 * @date 2022/12/12
 **/
public class Example1 {

    @Test
    public void test1() {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("a");
        pq.add("t");
        pq.add("c");
        pq.add("b");
        System.out.println("优先级队列元素：" + pq);
        // 优先级队列元素：[a, b, c, t]
    }

    /**
     * 遍历PriorityQueue
     */
    @Test
    public void test2() {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Collator.getInstance().compare(o1, o2);
            }
        });
        pq.add("a");
        pq.add("c");
        pq.add("b");
        System.out.println("队列元素" + pq);
        // 直接输出队列的顺序不是排序后的，是乱的，如果需要顺序处理则需要按照队列出队入队的方式处理
        while (pq.size() > 0) {
            System.out.println("移除队列头部：" + pq.poll());
        }
    }

}
