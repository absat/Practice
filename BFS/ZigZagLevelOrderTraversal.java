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
                if(!reverse){
                    TreeNode node = q.removeFirst();//q.pollFirst();
                    result.get(result.size()-1).add(node.val);
                    if(node.left!=null) 
                        q.add(node.left);
                    if(node.right!=null)
                        q.add(node.right);
                }
                else{
                    TreeNode node = q.pollLast();//q.removeLast();
                    result.get(result.size()-1).add(node.val);
                    if(node.right!=null)
                        q.addFirst(node.right);
                    if(node.left!=null) 
                        q.addFirst(node.left);
                }
            }
            reverse=!reverse;
        }
        return result;
    }
}

//tc and sc o of n