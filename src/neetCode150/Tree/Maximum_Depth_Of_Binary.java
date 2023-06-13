package neetCode150.Tree;

public class Maximum_Depth_Of_Binary {
    public static int maxDepth(TreeNode root){
        if(root == null) return 0;

        return 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(4,
                        new TreeNode(2
                                ,new TreeNode(1), new TreeNode(3)),
                        new TreeNode(7
                                ,new TreeNode(6), new TreeNode(9)));

        maxDepth(treeNode);
    }
}
