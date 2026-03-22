package LeetCode_Top_150.Binary_tree_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        AverageOfLevelsInBinaryTree_637 a = new AverageOfLevelsInBinaryTree_637();
         List<Double> avgs = a.averageOfLevels(t);
        for(double avg:avgs){
            System.out.println(avg);
        }

    }   

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgs = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            double sum = 0.0;
            int childCtr = 0;
            Queue<TreeNode> temp = new ArrayDeque<TreeNode>();

            while (!que.isEmpty()) {
                TreeNode frontNode = que.poll();
                sum += frontNode.getVal();
                childCtr++;
                if (frontNode.getLeft() != null) {
                    temp.add(frontNode.getLeft());
                }
                if (frontNode.getRight() != null) {
                    temp.add(frontNode.getRight());
                }
            }
            que = temp;
            avgs.add(sum*1.0/childCtr);
        }

        return avgs;
    }

    ArrayList<Integer> traverse(TreeNode root) {

        if (root.getLeft() != null) {
            traverse(root.getLeft());
        }
        if (root.getRight() != null) {
            traverse(root.getRight());
        }

        return null;
    }

}
