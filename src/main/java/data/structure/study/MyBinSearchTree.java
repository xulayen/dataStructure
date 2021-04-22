package data.structure.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
     * 
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
                    parent.size++;
                } else if (t.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                    parent.size++;
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
     * 
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
     * 
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
                parent.size--;
            } else if (t.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
                parent.size--;
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
     * 
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

    /**
     * 填充二叉树节点的右侧指针
     * 
     * @param root
     * @return
     */
    public TreeNode<T> linkTree(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        linkTwoNode(root.left, root.right);
        return root;
    }

    private void linkTwoNode(TreeNode<T> node1, TreeNode<T> node2) {
        if (node1 == null | node2 == null) {
            return;
        }
        node1.next = node2;
        linkTwoNode(node1.left, node1.right);
        linkTwoNode(node2.left, node2.right);
        linkTwoNode(node1.right, node2.left);
    }

    /**
     * 将二叉树转换为链表 步骤1、将 root 的左子树和右子树拉平。 步骤2、将 root 的右子树接到左子树下方，然后将整个左子树作为右子树。
     * 
     * @param root
     * @return
     */
    public TreeNode<T> flatten(TreeNode<T> root) {

        if (root == null)
            return null;

        flatten(root.left);
        flatten(root.right);

        // 后续遍历位置
        // 1、左右子树已经被拉平成一条链表
        TreeNode<T> left = root.left;
        TreeNode<T> right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode<T> p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

        return root;
    }

    /**
     * 以数组构建最大二叉树 数组中，最大元素为根，根的左边作为左子树；右边作为右子树构建二叉树
     * 
     * @param array
     * @return
     */
    public TreeNode<T> constructMaximumBinaryTree(int[] array) {
        if (array == null) {
            return null;
        }
        var root = build(array, 0, array.length - 1);
        return root;
    }

    private TreeNode<T> build(int[] nums, int lo, int hi) {
        System.out.println("lo:" + lo + ";hi:" + hi);
        if (lo > hi)
            return null;

        int maxVal = Integer.MIN_VALUE;
        int index = 0;
        for (var i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        var root = new TreeNode(maxVal);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode<T> root) {
        traverse(root);
        return res;
    }

    // 记录所有子树
    private HashMap<String, Integer> memo = new HashMap<String, Integer>();
    // 记录重复的子树根节点
    private List<TreeNode> res = new ArrayList<TreeNode>();

    private String traverse(TreeNode<T> root) {
        if (root == null) {
            return "#";
        }
        var left = traverse(root.left);
        var right = traverse(root.right);
        var subTree = left + "," + right + "," + root.element;
        var freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

    /**
     * 计算当前节点有多少个子节点
     * 
     * @param root
     * @return
     */
    public int count(TreeNode<T> root) {
        if (root == null)
            return 0;
        // 先计算出左右子树有多少个几点
        var left = count(root.left);
        var right = count(root.right);
        // 后序遍历位置
        return left + right + 1;
    }

    /**
     * 寻找第 K 小的元素 时间复杂度O(N)
     * 
     * @param root
     * @param k
     * @return
     */
    public T kthSmallest(TreeNode<T> root, int k) {
        traverseKthSmallest(root, k);
        return kthSmallestRes;
    }

    /**
     * 寻找第 K 小的元素 时间复杂度O(logN)
     * 
     * @param root
     * @param k
     * @return
     */
    public T kthSmallestFast(TreeNode<T> root, int k) {

        if (root == null || root.left == null || root.right == null)
            return null;

        kthSmallestFast(root.left, k);

        kthSmallestRank = root.size - root.left.size - 1;
        // 中序遍历位置
        if (k < root.size) {
            root = root.left;

        } else if (k > root.size) {
            root = root.right;
            k = k - root.right.size - 1;
        } else {
            kthSmallestRes = root.element;
        }

        kthSmallestFast(root.right, k);

        return kthSmallestRes;

    }

    // 记录结果
    private T kthSmallestRes;
    // 记录当前元素的排名
    private int kthSmallestRank = 0;

    /**
     * 寻找第 K 小的元素
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488101&idx=1&sn=6041ddda5f20ccde8a7036d3e3a1482c&chksm=9bd7ec6daca0657b2ab20a936437e2c8206384c3b1485fe91747ad796fa3a5b08556b2f4911e&scene=21#wechat_redirect
     */
    private void traverseKthSmallest(TreeNode<T> root, int k) {
        if (root == null) {
            return;
        }
        traverseKthSmallest(root.left, k);
        // 中序遍历位置
        kthSmallestRank++;
        if (kthSmallestRank == k) {
            kthSmallestRes = root.element;
            return;
        }
        traverseKthSmallest(root.right, k);
    }

    private TreeNode<T> createNewNode(T t) {
        return new TreeNode<T>(t);
    }

}
