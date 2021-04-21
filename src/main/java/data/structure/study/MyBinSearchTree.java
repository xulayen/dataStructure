package data.structure.study;

/**
 * 二叉查找树 时间复杂度 O(N)
 */
public class MyBinSearchTree<T extends Comparable<T>> {

    public TreeNode<T> root;

    public MyBinSearchTree(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * 搜索节点
     * 
     * @param t
     * @return
     */
    public boolean seach(T t) {
        var current = this.root;
        while (current != null) {
            if (t.compareTo(current.element) < 0) {
                current = current.left;
            } else if (t.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 插入节点
     * @param t
     * @return
     */
    public boolean insert(T t) {
        // 如果节点为空，则创建根节点
        if (this.root == null) {
            this.root = createNewNode(t);
        } else {
            // 负责就从根节点开始遍历，找到合适的父节点
            TreeNode<T> parent = null;
            TreeNode<T> current = this.root;
            while (current != null) {
                if (t.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (t.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            // 插入
            if (t.compareTo(parent.element) < 0) {
                parent.left = createNewNode(t);
            } else if (t.compareTo(parent.element) > 0) {
                parent.right = createNewNode(t);
            }
        }
        return true;
    }

    /**
     * 修改节点
     * @param oldV
     * @param newV
     * @return
     */
    public boolean update(T oldV, T newV) {
        // 是否存在
        if (oldV == null) {
            return false;
        } else {
            var del = delete(oldV);
            if (del)
                insert(newV);
            return false;
        }

    }

    /**
     * 删除节点
     * @param t
     * @return
     */
    public boolean delete(T t) {

        TreeNode<T> parent = null;
        TreeNode<T> current = this.root;

        while (current != null) {
            if (t.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (t.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        // 没有找到要删除的节点
        if (current == null) {
            return false;
        }

        // 场景1：当前要删除的节点没有左子树
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                // 架空当前要删除的节点
                if (t.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            TreeNode<T> parentOfRightMost = current;
            TreeNode<T> rightMost = current.left;
            // 找到左子树中最大的元素节点
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            // 把当前节点的左子树中的最大的元素复制给当前元素
            // 当前要删除的节点的左子树中的最大的节点替换当前将要删除节点
            current.element = rightMost.element;

            // parentOfRightMost和rightMost左孩子相连
            if (parentOfRightMost.right == rightMost) {
                // 当前要删除的节点的左子树中的最大的节点的左节点连接到当前要删除的节点的左子树中的最大的节点的父节点的右子树
                parentOfRightMost.right = rightMost.left;
            } else {
                // 当前要删除的节点的左子树中的最大的节点的左节点连接到当前要删除的节点的左子树中的最大的节点的父节点的左子树
                parentOfRightMost.left = rightMost.left;
            }
        }
        return true;
    }


            
    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode<T> invertTree(TreeNode<T> root) {
        if (root == null) {
            return null;
        }

        TreeNode<T> tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    private TreeNode<T> createNewNode(T t) {
        return new TreeNode(t);
    }

}
