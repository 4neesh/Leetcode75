import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class J_35_LeafSimilarTrees {

    public static void main(String[] args) {


    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2){

        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();
        getLeavesOfRoot(root1, root1Leaves);
        getLeavesOfRoot(root2, root2Leaves);

        return root1Leaves.equals(root2Leaves);
    }

    private static void getLeavesOfRoot(TreeNode root, List<Integer> leaves) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leaves.add(root.val);
        }
        getLeavesOfRoot(root.left, leaves);
        getLeavesOfRoot(root.right, leaves);
    }

}
