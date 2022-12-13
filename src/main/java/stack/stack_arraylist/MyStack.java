package stack.stack_arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用ArrayList实现栈数据结构
 *
 * @author zhangyu
 * @date 2022/12/13
 **/
public class MyStack {

    /**
     * 栈容器
     */
    private final List<Integer> intStack;

    /**
     * 初始化栈
     */
    public MyStack(int stackSize) {
        this.intStack = new ArrayList<>(stackSize);
    }

    /**
     * 入栈，将数据放入数组首位
     */
    public void push(int item) {
        intStack.add(0, item);
    }

    /**
     * 出栈
     */
    public int pop() {
        if (!intStack.isEmpty()) {
            int item = intStack.get(0);
            intStack.remove(0);
            return item;
        } else {
            return -1;
        }
    }

    /**
     * 查看栈顶元素
     */
    public int peek() {
        if (!intStack.isEmpty()) {
            return intStack.get(0);
        } else {
            return -1;
        }
    }

    /**
     * 获取栈内所有数据
     */
    public List<Integer> getAllItems() {
        return intStack;
    }

}
