public class J_36_CountGoodNodesInBT {

    public static void main(String[] args) {
        TreeNode3 tn1 = new TreeNode3(3);
        TreeNode3 tn2 = new TreeNode3(1);
        TreeNode3 tn3 = new TreeNode3(3);
        TreeNode3 tn4 = new TreeNode3(4);
        TreeNode3 tn5 = new TreeNode3(1);
        TreeNode3 tn6 = new TreeNode3(5);

        tn1.left = tn2;
        tn1.right = tn4;
        tn2.left = tn3;
        tn4.left = tn5;
        tn4.right = tn6;
        System.out.println(goodNodes(tn1));

    }

    public static int goodNodes(TreeNode3 root) {
        int count = dfs(root, 0);
        return count;
    }

    public static int dfs(TreeNode3 root, int max){
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


class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3() {}
    TreeNode3(int val) { this.val = val; }
    TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}