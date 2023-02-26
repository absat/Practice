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
    private HashMap<TreeNode, Integer> robResult = new HashMap<>();
    private HashMap<TreeNode, Integer> notRobResult = new HashMap<>();
    public int rob(TreeNode root) {
        return helper(root,false);
    }

    private int helper(TreeNode node, boolean isParentRobbed){
        if(node==null)
            return 0;
        if(isParentRobbed){
            if(robResult.containsKey(node)){
                return robResult.get(node);
            }
            else{
                int result = helper(node.left,false)+helper(node.right,false);
                robResult.put(node,result);
                return result;
            }
        }
        else{//important, here can either choose to rob or not rob, but previously only on choice(not rob, as paprent was robbed)
            if (notRobResult.containsKey(node)) {
                return notRobResult.get(node);
            }
            int rob = node.val + helper(node.left,true) + helper(node.right,true);
            int notRob = helper(node.left,false)+helper(node.right,false);

             int result = Math.max(rob,notRob);
            notRobResult.put(node,result);
            return result;
        }
    }
}
//TC O(N) since we run the helper function for all nodes once, and saved the results to prevent the second calculation.
//SC O(N), 2 hashmaps and recursion stack depth