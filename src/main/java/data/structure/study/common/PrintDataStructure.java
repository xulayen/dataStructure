package data.structure.study.common;

import data.structure.study.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintDataStructure {

    public static <T extends Comparable<?>> void printTreeNode(TreeNode<T> root) {
        int maxLevel = PrintDataStructure.maxLevel(root);

        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printTreeNodeInternal(List<TreeNode<T>> TreeNodes, int level, int maxLevel) {
        if (TreeNodes.isEmpty() || PrintDataStructure.isAllElementsNull(TreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        PrintDataStructure.printWhitespaces(firstSpaces);

        List<TreeNode<T>> newTreeNodes = new ArrayList<TreeNode<T>>();
        for (TreeNode<T> TreeNode : TreeNodes) {
            if (TreeNode != null) {
                System.out.print(TreeNode.element);
                newTreeNodes.add(TreeNode.left);
                newTreeNodes.add(TreeNode.right);
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                System.out.print(" ");
            }

            PrintDataStructure.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < TreeNodes.size(); j++) {
                PrintDataStructure.printWhitespaces(firstSpaces - i);
                if (TreeNodes.get(j) == null) {
                    PrintDataStructure.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (TreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    PrintDataStructure.printWhitespaces(1);

                PrintDataStructure.printWhitespaces(i + i - 1);

                if (TreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    PrintDataStructure.printWhitespaces(1);

                PrintDataStructure.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode<T> TreeNode) {
        if (TreeNode == null)
            return 0;

        return Math.max(PrintDataStructure.maxLevel(TreeNode.left), PrintDataStructure.maxLevel(TreeNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}