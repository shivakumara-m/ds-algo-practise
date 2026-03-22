
package LeetCode_Top_150.BinaryTreeTraversalBasic;

import java.util.ArrayList;


public class PreorderTraversal {
    public static void main(String[] args) {
        PreorderTraversal pre = new PreorderTraversal();


        TreeNode leftChild1 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightChild = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        TreeNode root = new TreeNode(1, leftChild1, rightChild);
        ArrayList<Integer> a = new ArrayList<>();
        pre.preorderTraversal(root, a);
        for(int j = 0; j < a.size(); j++){
            System.out.println(a.get(j));
        }
    }

    void preorderTraversal(TreeNode root, ArrayList<Integer> result) {
    
        if(root == null) {
            return;
        }
        result.add(root.getVal());

        if(root.getLeft() != null ) {
            preorderTraversal(root.getLeft(), result);
        }


        if (root.getRight() != null) {
            preorderTraversal(root.getRight(), result);
        }

    }
}
