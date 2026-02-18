import util.TreeNode;

public class J_43_DeleteNodeInBST {

    public static void main(String[] args) {


    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return root;
        }
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode current = root.right;
                while(current.left != null){
                    current = current.left;
                }
                root.val = current.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
