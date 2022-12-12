package tree.traverse_recursion_tree;


/**
 * 二叉树节点
 *
 * @author zhangyu
 * @date 2022/12/12
 **/
class Node {


    int value;
    
    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}