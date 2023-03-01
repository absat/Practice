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
    public TreeNode invertTree(TreeNode root) {
       return invert(root);
    }
    private TreeNode invert(TreeNode node){
         if(node==null)
            return null;
         TreeNode newLeft = invert(node.right);
        TreeNode newRight = invert(node.left);
        node.left = newLeft;
        node.right = newRight;
        return node;
    }
}