import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class J_41_BinaryTreeMaxSumRow {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(23);

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

    public int maxLevelSum(TreeNode root) {
        int maxLevel = 1;
        int currentLevelInt = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        Queue<TreeNode> nextLevel = new ArrayDeque<>();

        if(root == null){
            return -1;
        }
        currentLevel.add(root);

        while(!currentLevel.isEmpty()){

            int currentSum = 0;
            for(TreeNode node: currentLevel){
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
