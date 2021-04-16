package data.structure.study;

/**
 * 一棵树
 */
public class TreeNode<T> {
    public T element;
    public TreeNode<T> left;
    public TreeNode<T> right;

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
     * 
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
     * 
     * @param root
     */
    protected void inorder2(TreeNode<T> root) {
        if (root == null)
            return;

        inorder2(root.right);
        System.out.print(root.element + " ");
        inorder2(root.left);
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
