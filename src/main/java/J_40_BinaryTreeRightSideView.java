import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class J_40_BinaryTreeRightSideView {


    public static void main(String[] args) {

        TreeNode7 a = new TreeNode7(1);
        TreeNode7 b = new TreeNode7(2);
        TreeNode7 c = new TreeNode7(3);
        TreeNode7 d = new TreeNode7(4);
        TreeNode7 e = new TreeNode7(5);
        TreeNode7 f = new TreeNode7(6);
        TreeNode7 g = new TreeNode7(7);
        TreeNode7 h = new TreeNode7(8);

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

    public List<Integer> rightSideView(TreeNode7 root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return List.of();
        }

        Queue<TreeNode7> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);
        Queue<TreeNode7> nextLevel = new ArrayDeque<>();
        Integer currentLevelVal = 0;

        while(!currentLevel.isEmpty()) {
            for (TreeNode7 node : currentLevel) {
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

class TreeNode7 {
    int val;
    TreeNode7 left;
    TreeNode7 right;
    TreeNode7() {}
    TreeNode7(int val) { this.val = val; }
    TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}