package data.structure.study.common;

import data.structure.study.TreeNode;

public class Codec<T> {

    private String NULL = "#";

    private String ESP = ",";

    /**
     * 把一棵二叉树序列化成字符串
     * @param root
     * @return
     */
    public String serialize(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * 把字符串反序列化成二叉树
     * @param data
     * @return
     */
    public TreeNode<T> deserialize(String data) {
        String[] nodeStr = data.split(ESP);
        TreeNode<T> root = null;
        root=deserialize(nodeStr);
        return root;
    }

    int i = 0;
    private TreeNode<T> deserialize(String[] nodeStr) {

        if (nodeStr[i].equals(NULL)) {
            i++;
            return null;
        } else {
            /* 前序遍历位置 */
            TreeNode newNode = new TreeNode(0);
            newNode.element = Integer.parseInt(nodeStr[i]);
            i++;


            newNode.left = deserialize(nodeStr);
            newNode.right = deserialize(nodeStr);

            return newNode;
        }

    }

    private void serialize(TreeNode<T> root, StringBuilder sb) {

        if (root == null) {
            sb.append(NULL).append(ESP);
            return;
        }

        /* 前序遍历位置 */
        sb.append(root.element).append(ESP);

        serialize(root.left, sb);
        serialize(root.right, sb);

    }

}
