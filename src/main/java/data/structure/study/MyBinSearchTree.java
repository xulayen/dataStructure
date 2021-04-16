package data.structure.study;

/**
 * 二叉查找树
 */
public class MyBinSearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public MyBinSearchTree(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * 二叉搜索树
     * @param t
     * @return
     */
    public boolean seach(T t) {
        var current = this.root;
        while (current != null) {
            if (t.compareTo(current.element) < 0) {
                current= current.left;
            }else if(t.compareTo(current.element)>0){
                current=current.right;
            }else{
                return true;
            }
        }
        return false;
    }
}
