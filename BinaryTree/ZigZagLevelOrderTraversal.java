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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          if(root==null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            result.add(new ArrayList<>());
            for(int i=0;i<size;i++){
                if(reverse){
                    TreeNode node = q.removeLast();
                    result.get(result.size()-1).add(node.val);
                    
                     TreeNode right = node.right;
                    if(right != null){
                        q.addFirst(right);
                    }

                    TreeNode left = node.left;
                    if(left != null){
                        q.addFirst(left);
                    }
                }
                else{
                    TreeNode node = q.removeFirst();
                    result.get(result.size()-1).add(node.val);
                   
                    

                     TreeNode left = node.left;
                    if(left != null){
                        q.add(left);
                    }

                     TreeNode right = node.right;
                    if(right != null){
                        q.add(right);
                    }
                }
            }
            reverse = !reverse;
        }
        return result;
    }
}