package neetCode150.Tree;

import com.sun.source.tree.Tree;

import java.util.Stack;
import java.util.stream.Stream;

public class SolutionTree {
    public static void main(String[] args) {
        int[] nodeValue = {3, 1, 4, 3, -1, 1, 5};
        CreateTreeNode treeNode = new CreateTreeNode(nodeValue, 0);
        TreeNode root = treeNode.getTreeNode();


    }
}
