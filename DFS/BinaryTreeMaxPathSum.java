/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    private int solve(TreeNode root){
        if(root==null)
            return 0;
        int leftPathSum = Math.max(solve(root.left),0);
        int righPathSum = Math.max(solve(root.right),0);

        max = Math.max(max, leftPathSum + righPathSum + root.val);

        return Math.max(leftPathSum + root.val, righPathSum +root.val);
    }
}

/*
 * tc and sc o of n
 */