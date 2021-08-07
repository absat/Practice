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
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        List<Integer> ans = new ArrayList();
        TreeNode curr = root;
        while(!stack.isEmpty()||curr!=null){
            if(curr!=null){
                stack.addFirst(curr);
                curr=curr.left;
            }
            else{
                curr = stack.removeFirst();
                ans.add(curr.val);
                curr=curr.right;
            }            
        }
        return ans;
    }
}
//Time: O(n) 
//Space: O(h), stack space