import java.util.ArrayList;
import java.util.List;

public class J_35_LeafSimilarTrees {

    public static void main(String[] args) {


    }

    public static boolean leafSimilar(TreeNode2 root1, TreeNode2 root2){

        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();
        getLeavesOfRoot(root1, root1Leaves);
        getLeavesOfRoot(root2, root2Leaves);

        return root1Leaves.equals(root2Leaves);
    }

    private static void getLeavesOfRoot(TreeNode2 root, List<Integer> leaves) {
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


class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2() {}
    TreeNode2(int val) { this.val = val; }
    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}