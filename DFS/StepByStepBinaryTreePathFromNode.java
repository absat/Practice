//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/solutions/4894654/java-dfs/
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startb = new StringBuilder(), endb = new StringBuilder();
        dfs(root,startValue,startb);
        dfs(root,destValue,endb);

        int i = startb.length()-1, j = endb.length()-1;
        while(i>=0 && j>=0 && startb.charAt(i)==endb.charAt(j)){
            i--; j--;
        }
        StringBuilder start = new StringBuilder();
        for(int k = 0; k<=i;k++){
            start.append("U");
        }

        return start.toString() + endb.reverse().toString().substring(endb.length()-j-1);
    }

    private boolean dfs(TreeNode root, int value, StringBuilder sb){
        if(root==null)
            return false;
        if(root.val==value){
            return true;
        }
        if(dfs(root.left, value, sb)){
            sb.append("L");
        } else if(dfs(root.right, value, sb)){
            sb.append("R");
        } 
        return sb.length() > 0;
    }
}