package stack.stack_arraylist;

/**
 * 使用ArrayList实现栈数据结构测试
 *
 * @author zhangyu
 * @date 2022/12/13
 **/
public class Main {

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        myStack.push(3);
        myStack.push(5);
        System.out.println(myStack.getAllItems());
    }
}
