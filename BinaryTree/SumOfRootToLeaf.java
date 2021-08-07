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
    public int sumNumbers(TreeNode root) {
        return solve(root,0);
    }
    public int solve(TreeNode node, int numNow){
        if(node==null)
            return 0;
        numNow = numNow*10+node.val;
        if(node.left==null&&node.right==null){
            return numNow;
        }

        return solve(node.left,numNow)+solve(node.right,numNow);
        
    }
}