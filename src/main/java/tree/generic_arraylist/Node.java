package tree.generic_arraylist;

import java.util.ArrayList;

/**
 * 节点Node
 *
 * @author zhangyu
 * @date 2022/12/12
 **/
class Node<T> {

    /**
     *
     */
    private final T root;

    /**
     * 一个父节点
     */
    private Node<T> parent;

    /**
     * 孩子节点列表
     */
    private final ArrayList<Node<T>> children;

    /**
     * 初始化节点
     */
    public Node(T root) {
        this.root = root;
        children = new ArrayList<>();
    }

    /**
     * 添加子节点
     */
    public Node<T> addChild(T child) {
        Node<T> childNode = new Node<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public T getRoot() {
        return root;
    }

    /**
     * 判断是否是头结点
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * 判断是否是叶子节点
     */
    public boolean isLeaf() {
        return children.isEmpty();
    }

    /**
     * 获取当前节点层级
     */
    public int getLevel() {
        if (this.isRoot()) {
            return 0;
        } else {
            return parent.getLevel() + 1;
        }
    }

    @Override
    public String toString() {
        return root != null ? root.toString() : "null";
    }
}