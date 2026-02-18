import util.TreeNode;

public class J_42_SearchBinarySearchTree {

    public static void main(String[] args) {



    }

    public TreeNode searchBST(TreeNode root, int val) {

        while(root != null){

            if(root.val == val){
                return root;
            }
            if(val < root.val){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return null;
    }


}
