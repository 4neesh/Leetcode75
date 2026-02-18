package patterns;

import util.TreeNode;

import java.util.*;

public class BreadthFirstSearch {

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

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        System.out.println(bfs.levelOrderTraversal(a));

    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root){

        if(root == null){
            return List.of();
        }

        Queue<TreeNode> current = new ArrayDeque<>();
        current.add(root);
        Queue<TreeNode> nextLevel = new ArrayDeque<>();
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        while(!current.isEmpty()){

            for(TreeNode node: current){
                level.add(node.val);
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
            }
            result.add(level);
            level = new ArrayList<>();
            current = nextLevel;
            nextLevel = new ArrayDeque<>();
        }

        return result;
    }
}