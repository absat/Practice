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

 //First Try mine, yay!
class Solution {
    private int ans=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans; 
    }

    private Pair solve(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair leftSubTree = solve(root.left);
        Pair rightSubTree = solve(root.right);
        int sum = leftSubTree.sum + rightSubTree.sum + root.val;
        int count  = leftSubTree.count + rightSubTree.count + 1;
        if(sum/count==root.val)
            ans++;
        return new Pair(sum,count);
    }
    class Pair{
        int sum, count;
        Pair(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }
}

//Better Solution with Pair lib class
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
    private int ans=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans; 
    }

    private Pair<Integer,Integer> solve(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair<Integer,Integer> leftSubTree = solve(root.left);
        Pair<Integer,Integer> rightSubTree = solve(root.right);
        int sum = leftSubTree.getKey() + rightSubTree.getKey() + root.val;
        int count  = leftSubTree.getValue() + rightSubTree.getValue() + 1;
        if(sum/count==root.val)
            ans++;
        return new Pair(sum,count);
    }
} 