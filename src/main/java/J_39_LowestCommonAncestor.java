public class J_39_LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode7 a = new TreeNode7(-1);
        TreeNode7 b = new TreeNode7(0);
        TreeNode7 c = new TreeNode7(8);
        TreeNode7 d = new TreeNode7(2);
        TreeNode7 e = new TreeNode7(7);
        TreeNode7 f = new TreeNode7(4);
        TreeNode7 g = new TreeNode7(1);
        TreeNode7 h = new TreeNode7(0);
        TreeNode7 i = new TreeNode7(8);
        a.left = b;
        a.right = c;

        J_39_LowestCommonAncestor lca = new J_39_LowestCommonAncestor();

        System.out.println(lca.lowestCommonAncestor(a, b, f).val);
    }

    public TreeNode7 lowestCommonAncestor(TreeNode7 root, TreeNode7 p, TreeNode7 q) {

        if(root == null) return null;

        if(root == p || root == q) return root;

        TreeNode7 left = lowestCommonAncestor(root.left, p, q);
        TreeNode7 right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left == null ? right : left;
    }

}


class TreeNode6 {
    int val;
    TreeNode7 left;
    TreeNode7 right;
    TreeNode6() {}
    TreeNode6(int val) { this.val = val; }
    TreeNode6(int val, TreeNode7 left, TreeNode7 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}