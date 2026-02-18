import util.TreeNode;

public class J_34_MaxDepthBinaryTree {

    public int maxDepth(TreeNode root){

        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
