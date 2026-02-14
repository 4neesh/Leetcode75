import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class J_37_PathSum3 {

    private Map<Long, Integer> cumulativeSums = new HashMap<>();
    private Integer count = 0;

    public static void main(String[] args) {

        TreeNode4 a = new TreeNode4(10);
        TreeNode4 b = new TreeNode4(5);
        TreeNode4 c = new TreeNode4(3);
        TreeNode4 d = new TreeNode4(3);
        TreeNode4 e = new TreeNode4(-2);
        TreeNode4 f = new TreeNode4(2);
        TreeNode4 g = new TreeNode4(1);
        TreeNode4 h = new TreeNode4(-3);
        TreeNode4 i = new TreeNode4(11);
        TreeNode4 j = new TreeNode4(1);
        TreeNode4 k = new TreeNode4(-2);
        TreeNode4 l = new TreeNode4(-3);


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

    public int pathSum(TreeNode4 root, int targetSum) {

        this.dfs(root, targetSum, 0L);
        return this.count;
    }

    private void dfs(TreeNode4 root, Integer targetSum, long cumulativeSum){
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


class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4() {}
    TreeNode4(int val) { this.val = val; }
    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}