package LeetCode_Top_150.BinaryTreeTraversalBasic;

import java.util.ArrayList;


public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal i = new InorderTraversal();


        TreeNode leftChild1 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightChild = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        TreeNode root = new TreeNode(1, leftChild1, rightChild);
        ArrayList<Integer> a = new ArrayList<>();
        i.inorderTraversal(root, a);
        for(int j = 0; j < a.size(); j++){
            System.out.println(a.get(j));
        }
    }

    void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
    
        if(root == null) {
            return;
        }

        if(root.getLeft() != null ) {
            inorderTraversal(root.getLeft(), result);
        }

        result.add(root.getVal());

        if (root.getRight() != null) {
            inorderTraversal(root.getRight(), result);
        }

    }
}
