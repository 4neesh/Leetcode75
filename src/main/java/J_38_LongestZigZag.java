public class J_38_LongestZigZag {

    public static void main(String[] args) {
        J_38_LongestZigZag aa = new J_38_LongestZigZag();
        TreeNode5 a = new TreeNode5();
        System.out.println(aa.longestZigZag(a));

    }
    private int maxCount = 0;

    public int longestZigZag(TreeNode5 root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxCount;
    }

    public void dfs(TreeNode5 root, boolean fromLeft, int count){

        if(root == null){
            return;
        }
        this.maxCount = Math.max(count, this.maxCount);
        if(fromLeft){
            dfs(root.right, false, count+= 1);
            dfs(root.left, true, 1);
        }
        else{
            dfs(root.left, true, count+= 1);
            dfs(root.right, false, 1);
        }

    }
}

class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5() {}
    TreeNode5(int val) { this.val = val; }
    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}