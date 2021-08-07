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
    public int minCameraCover(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1],ans[2]);
    }
    public int[] solve(TreeNode node){
        if(node==null)
            return new int[]{0,0,99999};
        int[] left = solve(node.left);
        int[] right = solve(node.right);
        int mleft12 = Math.min(left[1],left[2]);
        int mright12 = Math.min(right[1],right[2]);
        
        int d0=left[1]+right[1];
        int d1 = Math.min(left[2]+mright12,right[2]+mleft12);
        int d2 = 1+Math.min(left[0],mleft12)+Math.min(right[0],mright12);
        return new int[]{d0,d1,d2};
    }
}