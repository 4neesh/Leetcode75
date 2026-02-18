import util.TreeNode;

public class J_36_CountGoodNodesInBT {

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(1);
        TreeNode tn6 = new TreeNode(5);

        tn1.left = tn2;
        tn1.right = tn4;
        tn2.left = tn3;
        tn4.left = tn5;
        tn4.right = tn6;
        System.out.println(goodNodes(tn1));

    }

    public static int goodNodes(TreeNode root) {
        int count = dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public static int dfs(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int count = 0;
        int currentVal = root.val;
        if(currentVal >= max){
            count = 1;
        }
        count += dfs(root.left, Math.max(currentVal, max));
        count += dfs(root.right, Math.max(currentVal, max));
        return count;
    }

}