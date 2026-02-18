import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class J_37_PathSum3 {

    private Map<Long, Integer> cumulativeSums = new HashMap<>();
    private Integer count = 0;

    public static void main(String[] args) {

        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(-2);
        TreeNode f = new TreeNode(2);
        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(-3);
        TreeNode i = new TreeNode(11);
        TreeNode j = new TreeNode(1);
        TreeNode k = new TreeNode(-2);
        TreeNode l = new TreeNode(-3);


        a.left = b;
        b.left = c;
        c.left = d;
        c.right = e;
        b.right = f;
        f.right = g;
        a.right = h;
        h.right = i;

        j.left = k;
        j.right = l;
        J_37_PathSum3 main = new J_37_PathSum3();
        System.out.println(main.pathSum(a, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {

        this.dfs(root, targetSum, 0L);
        return this.count;
    }

    private void dfs(TreeNode root, Integer targetSum, long cumulativeSum){
        if(root == null){
            return;
        }
        if(root.val + cumulativeSum == targetSum){
            this.count += 1;
        }
        long requiredVal = root.val + cumulativeSum - targetSum;
        this.count += cumulativeSums.getOrDefault(requiredVal, 0);
        this.cumulativeSums.merge(root.val+ cumulativeSum, 1, Integer::sum);

        dfs(root.left, targetSum, cumulativeSum + root.val);
        dfs(root.right, targetSum, cumulativeSum + root.val);

        this.cumulativeSums.merge(root.val + cumulativeSum, -1, Integer::sum);
    }

}
