
package LeetCode_Top_150.BinaryTreeTraversalBasic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal level = new LevelOrderTraversal();

        TreeNode leftChild1 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightChild = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        TreeNode root = new TreeNode(1, leftChild1, rightChild);
        ArrayList<Integer> a = new ArrayList<>();
        level.levelorderTraversal(root, a);
        for (int j = 0; j < a.size(); j++) {
            System.out.println(a.get(j));
        }
    }

    void levelorderTraversal(TreeNode root, ArrayList<Integer> result) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.getVal());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

    }
}
