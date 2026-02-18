import util.TreeNode;

public class J_38_LongestZigZag {

    public static void main(String[] args) {
        J_38_LongestZigZag aa = new J_38_LongestZigZag();
        TreeNode a = new TreeNode();
        System.out.println(aa.longestZigZag(a));

    }
    private int maxCount = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxCount;
    }

    public void dfs(TreeNode root, boolean fromLeft, int count){

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
