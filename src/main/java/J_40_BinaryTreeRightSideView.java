import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class J_40_BinaryTreeRightSideView {


    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;

        J_40_BinaryTreeRightSideView bfs = new J_40_BinaryTreeRightSideView();
        System.out.println(bfs.rightSideView(a));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return List.of();
        }

        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);
        Queue<TreeNode> nextLevel = new ArrayDeque<>();
        Integer currentLevelVal = 0;

        while(!currentLevel.isEmpty()) {
            for (TreeNode node : currentLevel) {
                currentLevelVal = node.val;
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(currentLevelVal);
            currentLevelVal = 0;
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }
        return result;
    }
}
