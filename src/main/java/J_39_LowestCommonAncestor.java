public class J_39_LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode6 a = new TreeNode6(-1);
        TreeNode6 b = new TreeNode6(0);
        TreeNode6 c = new TreeNode6(8);
        TreeNode6 d = new TreeNode6(2);
        TreeNode6 e = new TreeNode6(7);
        TreeNode6 f = new TreeNode6(4);
        TreeNode6 g = new TreeNode6(1);
        TreeNode6 h = new TreeNode6(0);
        TreeNode6 i = new TreeNode6(8);
        a.left = b;
        a.right = c;

        J_39_LowestCommonAncestor lca = new J_39_LowestCommonAncestor();

        System.out.println(lca.lowestCommonAncestor(a, b, f).val);
    }

    public TreeNode6 lowestCommonAncestor(TreeNode6 root, TreeNode6 p, TreeNode6 q) {

        if(root == null) return null;

        if(root == p || root == q) return root;

        TreeNode6 left = lowestCommonAncestor(root.left, p, q);
        TreeNode6 right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left == null ? right : left;
    }
    
}


class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;
    TreeNode6() {}
    TreeNode6(int val) { this.val = val; }
    TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}