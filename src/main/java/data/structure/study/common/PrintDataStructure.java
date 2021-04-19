package data.structure.study.common;

import data.structure.study.TreeNode;

/**
 * 以可视化视图打印树结构
 */
public class PrintDataStructure<T> {
   
    // 使用先序遍历方式打印二叉树
    private void traversalPrint(TreeNode<T> root) {
        if (root == null)
            return;

        System.out.print(root.element + " ");
        traversalPrint(root.left);
        traversalPrint(root.right);

    }

    public void print(TreeNode<T> root) {
        traversalPrint(root);
    }

}
