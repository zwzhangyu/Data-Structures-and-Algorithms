package tree.generic_arraylist;

/**
 * 使用通用方法和 ArrayList 创建树
 * 参考笔记：《在 Java 中实现树》
 *
 * @author zhangyu
 * @date 2022/12/12
 **/
public class JavaTree {


    public static void main(String[] args) {

        // 创建两个父节点
        Node<String> parentA = new Node<>("父节点A");
        Node<String> parentB = new Node<>("父节点B");
        // 父节点A添加几个子节点
        Node<String> child1 = parentA.addChild("child1");
        {
            Node<String> innerChildA = child1.addChild("子节点A");
            Node<String> innerChildB = child1.addChild("子节点B");
            Node<String> innerChildC = child1.addChild("子节点C");
            System.out.println("-" + child1);
            System.out.println("--" + innerChildA);
            System.out.println("--" + innerChildB);
            System.out.println("--" + innerChildC);
            System.out.println("child1节点的层级 " + child1.getLevel());
            System.out.println("innerChildA节点的层级" + innerChildA.getLevel());
        }
        System.out.println(parentB.getRoot());
        Node<String> child2 = parentB.addChild("child2");
        {
            Node<String> innerChildA = child1.addChild("子节点A");
            Node<String> innerChildB = child1.addChild("子节点B");
            Node<String> innerChildC = child1.addChild("子节点C");
            {
                Node<String> innerChild4 = innerChildC.addChild("子节点C-A");
                System.out.println(innerChild4.getLevel());
                System.out.println("innerChild4节点是否是叶子节点" + innerChild4.isLeaf());
            }
            System.out.println("-" + child2);
            System.out.println("--" + innerChildA);
            System.out.println("--" + innerChildB);
            System.out.println("--" + innerChildC);
            System.out.println("child2节点层级 " + child2.getLevel());
        }
    }
}