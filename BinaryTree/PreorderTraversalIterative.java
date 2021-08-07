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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        stack.addFirst(root);
        List<Integer> ans = new ArrayList();
        while(stack.size()!=0){
            TreeNode curr = stack.removeFirst();
            if(curr!=null){
                ans.add(curr.val);
                stack.addFirst(curr.right);
                stack.addFirst(curr.left);
            }
            
        }
        return ans;
    }
}
//Time: O(n) 
//Space: O(h), stack space