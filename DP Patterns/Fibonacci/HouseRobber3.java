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
// class SolutionRec {
//     public int rob(TreeNode root) {
//         int[] answer = helper(root);
//         return Math.max(answer[0],answer[1]);
//     }
//     public int[] helper(TreeNode node){
//         if(node==null){
//             return new int[]{0,0};
//         }
//         int[] left = helper(node.left);
//         int[] right= helper(node.right);
//         int rob = node.val +left[1]+right[1];
//         int notRob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
//         return new int[]{rob,notRob};
//     }
// }
//TC- O(N)
//Space-O(N), REC STACK WC-o(N), BC-o(logN)
class SolutionMemoPreferred {
    HashMap<TreeNode,Integer> robbed = new HashMap();//parentRobbed
    HashMap<TreeNode,Integer> notRobbed = new HashMap();//parentNotRobbed
    public int rob(TreeNode root) {
        return helper(root,false);// This is very critical, because obvously root node has no parent, and also false here 
                                  // ensures both rob & not rob cases for root node are explored
    }
    int helper(TreeNode node, boolean parentRobbed){
        if(node==null)
            return 0;
        if(parentRobbed){
            if(robbed.containsKey(node))
                return robbed.get(node);
            int result = helper(node.left,false)+helper(node.right,false);
            robbed.put(node,result);
            return result;
        }
        else{
            if (notRobbed.containsKey(node)) {
                return notRobbed.get(node);
            }
            int rob = node.val+helper(node.left, true) + helper(node.right, true);
            int notRob = helper(node.left, false) + helper(node.right, false);
            int result = Math.max(rob, notRob);
            notRobbed.put(node, result);
            return result;
            }
        }
}
//TC- O(N), since we run the helper function for all nodes once, and saved the results to prevent the second calculation.
//S - O(N), since we need two maps with the size of O(N) to store the results, and O(N) space for stacks to start recursion.