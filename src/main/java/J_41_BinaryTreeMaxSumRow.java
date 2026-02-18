import java.util.ArrayDeque;
import java.util.Queue;

public class J_41_BinaryTreeMaxSumRow {

    public static void main(String[] args) {

        TreeNode8 a = new TreeNode8(1);
        TreeNode8 b = new TreeNode8(2);
        TreeNode8 c = new TreeNode8(3);
        TreeNode8 d = new TreeNode8(4);
        TreeNode8 e = new TreeNode8(5);
        TreeNode8 f = new TreeNode8(6);
        TreeNode8 g = new TreeNode8(7);
        TreeNode8 h = new TreeNode8(23);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;

        J_41_BinaryTreeMaxSumRow bfs = new J_41_BinaryTreeMaxSumRow();
        System.out.println(bfs.maxLevelSum(a));
    }

    public int maxLevelSum(TreeNode8 root) {
        int maxLevel = 1;
        int currentLevelInt = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode8> currentLevel = new ArrayDeque<>();
        Queue<TreeNode8> nextLevel = new ArrayDeque<>();

        if(root == null){
            return -1;
        }
        currentLevel.add(root);

        while(!currentLevel.isEmpty()){

            int currentSum = 0;
            for(TreeNode8 node: currentLevel){
                currentSum += node.val;
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                maxLevel = currentLevelInt;
            }
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
            currentLevelInt++;
        }
        return maxLevel;
    }
}

class TreeNode8 {
    int val;
    TreeNode8 left;
    TreeNode8 right;
    TreeNode8() {}
    TreeNode8(int val) { this.val = val; }
    TreeNode8(int val, TreeNode8 left, TreeNode8 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
