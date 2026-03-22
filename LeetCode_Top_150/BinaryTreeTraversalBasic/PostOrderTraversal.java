
package LeetCode_Top_150.BinaryTreeTraversalBasic;

import java.util.ArrayList;

public class PostOrderTraversal {
    public static void main(String[] args) {
        PostOrderTraversal pos = new PostOrderTraversal();

        TreeNode leftChild1 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightChild = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        TreeNode root = new TreeNode(1, leftChild1, rightChild);
        ArrayList<Integer> a = new ArrayList<>();
        pos.postorderTraversal(root, a);
        for (int j = 0; j < a.size(); j++) {
            System.out.println(a.get(j));
        }
    }

    void postorderTraversal(TreeNode root, ArrayList<Integer> result) {

        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            postorderTraversal(root.getLeft(), result);
        }

        if (root.getRight() != null) {
            postorderTraversal(root.getRight(), result);
        }
        result.add(root.getVal());

    }
}
