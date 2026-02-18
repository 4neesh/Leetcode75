import util.TreeNode;

public class J_39_LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(0);
        TreeNode i = new TreeNode(8);
        a.left = b;
        a.right = c;

        J_39_LowestCommonAncestor lca = new J_39_LowestCommonAncestor();

        System.out.println(lca.lowestCommonAncestor(a, b, f).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left == null ? right : left;
    }

}
