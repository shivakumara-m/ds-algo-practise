package LeetCode_Top_150.BinaryTreeTraversalBasic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal_103 b = new BinaryTreeZigzagLevelOrderTraversal_103();
         TreeNode leftChild1 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightChild = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        TreeNode root = new TreeNode(1, leftChild1, rightChild);
        System.out.println(b.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean order = true;
        if (root == null)
            return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            Queue<TreeNode> tmpQ = new ArrayDeque<>();
            while (!q.isEmpty()) {
                TreeNode front = q.poll();
                if (front.left != null) {
                    tmpQ.add(front.left);
                }
                if (front.right != null) {
                    tmpQ.add(front.right);
                }
                row.add(front.val);
            }
            q = tmpQ;
            if (order) {
                res.add(row);
            } else {
                res.add(row.reversed());
            }
            order = !order;
        }
        return res;

    }
}
