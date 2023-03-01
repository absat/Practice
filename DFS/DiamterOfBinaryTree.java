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
 /*
The key observation to make is: the longest path has to be between two leaf nodes.
 We can prove this with contradiction. Imagine that we have found the longest path,
  and it is not between two leaf nodes. We can extend that path by 1, by adding the 
  child node of one of the end nodes (as at least one must have a child, given that they aren't both leaves). 
  This contradicts the fact that our path is the longest path. Therefore, the longest path must be between two leaf nodes.

Moreover, we know that in a tree, nodes are only connected with their parent node and 2 children. 
Therefore we know that the longest path in the tree would consist of a node, its longest left branch,
 and its longest right branch. So, our algorithm to solve this problem will find the node where the
  sum of its longest left and right branches is maximized. This would hint at us to apply
   Depth-first search (DFS) to count each node's branch lengths, because it would allow us to
    dive deep into the leaves first, and then start counting the edges upwards.
 */
class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return diameter;
    }

    private int solve(TreeNode node){
        if(node==null)
            return 0;
        int leftPath = solve(node.left);
        int righPath = solve(node.right);

        diameter = Math.max(diameter,leftPath+righPath);
        return Math.max(leftPath,righPath)+1;
    }
}
/*
 * TC o of n
 * SC O of n (call stack for recursion for skewed tree)
 */