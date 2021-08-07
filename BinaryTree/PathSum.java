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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root,targetSum);
    }
    public boolean solve(TreeNode node, int targetSum){
        if(node==null)
            return false;
        targetSum-=node.val;
        if(node.left==null&&node.right==null)
            if(targetSum==0)
                return true;
            else
                return false;
        return solve(node.left,targetSum)||solve(node.right,targetSum);
    }
}