package neetCode150.Tree;

import com.sun.source.tree.Tree;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Invert_Binary_Tree {
    // #1
    public static TreeNode invertTree(TreeNode root){
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // #2
    public static TreeNode invertTree2(TreeNode root){
        if(root == null) return null;
        TreeNode temp = new TreeNode(root.val);
        temp.left = invertTree2(root.right);
        temp.right = invertTree2(root.left);

        return temp;
    }

    public static void main(String[] args) {
        TreeNode testNode =
                new TreeNode(4,
                        new TreeNode(2
                        ,new TreeNode(1), new TreeNode(3)),
                        new TreeNode(7
                        ,new TreeNode(6), new TreeNode(9)));
        testNode = invertTree2(testNode);
    }
}
