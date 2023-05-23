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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        HashMap<Integer,List<Integer>> hm= new HashMap<>();
        Queue<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        int column=0;
        queue.offer(new Pair(root, column));
        int minColumn=0,maxColumn=0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column=p.getValue();
            if(!hm.containsKey(column)){
                hm.put(column, new ArrayList<>());
            }
            hm.get(column).add(root.val);
            minColumn = Math.min(column, minColumn);
            maxColumn = Math.max(column, maxColumn);

            if(root.left!=null)
                queue.offer(new Pair(root.left, column-1));
            if(root.right!=null )    
                queue.offer(new Pair(root.right, column+1));

        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=minColumn; i<=maxColumn;i++){
            result.add(hm.get(i));
        }
        return result;
    }
}
//TC AND SC O OF N