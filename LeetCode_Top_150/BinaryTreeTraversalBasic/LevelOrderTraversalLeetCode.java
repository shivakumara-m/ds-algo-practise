

package LeetCode_Top_150.BinaryTreeTraversalBasic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalLeetCode
 {
    public static void main(String[] args) {
        LevelOrderTraversalLeetCode level = new LevelOrderTraversalLeetCode();

        TreeNode leftChild1 = new TreeNode(9);
        TreeNode rightChild = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        TreeNode root = new TreeNode(3, leftChild1, rightChild);
        ArrayList<Integer> a = new ArrayList<>();
        level.levelorderTraversal(root, a);
        for (int j = 0; j < a.size(); j++) {
            System.out.println(a.get(j));
        }
    }

    List<List<Integer>> levelorderTraversal(TreeNode root, ArrayList<Integer> result) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new ArrayDeque<>();
            List<Integer> tmpVal = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode front = queue.poll();
                //tmp.add(front);
                tmpVal.add(front.val);
                if (front.left != null) {
                    tmp.add(front.left);
                }
                if (front.right != null) {
                    tmp.add(front.right);
                }

            }
            queue = tmp;
            list.add(tmpVal);
        }
        System.out.println(list.toString());
        return list;
    }
}
