package LeetCode_Top_150.BinaryTreeTraversalBasic;

public class IsBalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        IsBalancedTree treeHeight = new IsBalancedTree();
        System.out.println(treeHeight.getHeight(root));
    }

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh =  getHeight(root.left);
        int rh = getHeight(root.right);
        return 1 + Math.max(lh, rh);

    }
}
