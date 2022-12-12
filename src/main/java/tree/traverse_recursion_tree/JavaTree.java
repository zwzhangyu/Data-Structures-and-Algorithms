package tree.traverse_recursion_tree;

/**
 * 使用递归方法实现二叉树
 *
 * @author zhangyu
 * @date 2022/12/11
 **/
public class JavaTree {

    private Node root;

    /**
     * 递归遍历树
     *
     * @param node 头结点
     */
    public void traverseRecursionTree(Node node) {
        if (node != null) {
            // 先遍历左边节点
            traverseRecursionTree(node.left);
            // 遍历中间节点
            System.out.println("输出节点值：" + node.value);
            // 遍历右边节点
            traverseRecursionTree(node.right);
        }
    }

    public static void main(String[] args) {
        JavaTree javaTree = new JavaTree();
        // 创建节点
        javaTree.root = new Node(10);
        javaTree.root.left = new Node(6);
        javaTree.root.right = new Node(5);
        javaTree.root.left.left = new Node(3);
        System.out.println("开始打印二叉树");
        javaTree.traverseRecursionTree(javaTree.root);
    }
}