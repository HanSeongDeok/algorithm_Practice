package neetCode150.Tree;

import com.sun.source.tree.Tree;

public class CreateTreeNode {
    private int[] treeNodeValue;
    private int startIndex;

    public CreateTreeNode(int[] treeNodeValue, int startIndex) {
        this.treeNodeValue = treeNodeValue;
        this.startIndex = startIndex;
    }

    public TreeNode getTreeNode(){
        return makeTreeNode(startIndex);
    }

    private TreeNode makeTreeNode(int index){
        if(treeNodeValue.length <= index || treeNodeValue[index] == -1){
            return null;
        }

        TreeNode root = new TreeNode(treeNodeValue[index]);
        root.left = makeTreeNode(2*index+1);
        root.right = makeTreeNode(2*index+2);
        return root;
    }
}
