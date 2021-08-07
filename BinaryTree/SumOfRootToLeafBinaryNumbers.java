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
    public int sumRootToLeaf(TreeNode root) {
        return solve(root,0);
    }
    public int solve(TreeNode node, int number){
        if(node==null)
            return 0;
        number=number*2+node.val;
        if(node.left==null&&node.right==null){
            return number;

        }
        return solve(node.left,number)+solve(node.right,number);
            
    }
}