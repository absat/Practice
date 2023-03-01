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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return levels;
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
           levels.add(new ArrayList<Integer>());//IMP
           int level_length = q.size();
           for(int i=0;i<level_length;i++){
               TreeNode node = q.remove();
               levels.get(level).add(node.val);
               if(node.left!=null) q.add(node.left);
               if(node.right!=null) q.add(node.right);
           }
           level++;
        }
        return levels;
    }
}

//tc n sc o of n