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
final class BalancedStatusAndHeight{
        public boolean balanced;
        public int height;
        
        BalancedStatusAndHeight(boolean balanced, int height){
            this.balanced = balanced;
            this.height = height;
        }
    }
class Solution {
    
    public boolean isBalanced(TreeNode root) {
        return solve(root).balanced;
    }
    
    public BalancedStatusAndHeight solve(TreeNode root){
        if(root==null)
            return new BalancedStatusAndHeight(true,-1);
        
        BalancedStatusAndHeight leftResult = solve(root.left);
        if(!leftResult.balanced)
            return leftResult;
        
        BalancedStatusAndHeight rightResult = solve(root.right);
        if(!rightResult.balanced)
            return rightResult;
        
        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) < 2; 
        return new BalancedStatusAndHeight( isBalanced,Math.max(leftResult.height, rightResult.height) + 1);
    }
}