import java.util.*;

public class Pattern_BreadthFirstSearch {

    public static void main(String[] args) {

        BFSTree a = new BFSTree(1);
        BFSTree b = new BFSTree(2);
        BFSTree c = new BFSTree(3);
        BFSTree d = new BFSTree(4);
        BFSTree e = new BFSTree(5);
        BFSTree f = new BFSTree(6);
        BFSTree g = new BFSTree(7);
        BFSTree h = new BFSTree(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;

        Pattern_BreadthFirstSearch bfs = new Pattern_BreadthFirstSearch();
        System.out.println(bfs.levelOrderTraversal(a));

    }

    public List<List<Integer>> levelOrderTraversal(BFSTree root){

        if(root == null){
            return List.of();
        }

        Queue<BFSTree> current = new ArrayDeque<>();
        current.add(root);
        Queue<BFSTree> nextLevel = new ArrayDeque<>();
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        while(!current.isEmpty()){

            for(BFSTree node: current){
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


class BFSTree {
    int val;
    BFSTree left;
    BFSTree right;
    BFSTree() {}
    BFSTree(int val) { this.val = val; }
    BFSTree(int val, BFSTree left, BFSTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}