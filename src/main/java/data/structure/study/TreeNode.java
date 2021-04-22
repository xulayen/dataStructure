package data.structure.study;

/**
 * 一棵树
 */
public class TreeNode<T> {
    public T element;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> next;

    public TreeNode(T e) {
        element = e;
    }

    /**
     * 先序遍历
     * 
     * @param root
     */
    protected void preorder(TreeNode<T> root) {
        if (root == null)
            return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 中序遍历 
     * 升序
     * @param root
     */
    protected void inorder(TreeNode<T> root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    /**
     * 中序遍历 
     * 降序
     * @param root
     */
    protected void inorderDesc(TreeNode<T> root) {
        if (root == null)
            return;

        inorderDesc(root.right);
        System.out.print(root.element + " ");
        inorderDesc(root.left);
    }

    /**
     * 后序遍历
     * 
     * @param root
     */
    protected void postorder(TreeNode<T> root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }
}
