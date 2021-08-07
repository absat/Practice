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
class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result =new ArrayList();
        result = solve(root,targetSum,result, new ArrayList());
        return result;
    }
    public List<List<Integer>> solve(TreeNode node, int sum, List<List<Integer>> result, ArrayList<Integer> list){
        if(node==null)
            return result;
        list.add(node.val);
        if(node.left==null&& node.right==null)
        {
            if(sum-node.val==0){
                result.add(new ArrayList<>(list));
            }
        }
        else{
            result = solve(node.left,sum-node.val,result,list);
            result = solve(node.right,sum-node.val,result,list);
        }
        list.remove(list.size()-1);
        return result;
    }
}
//Time: O(N^2), . In the worst case, we could have a complete binary tree and if that is the case, 
//then there would be N/2 leafs. For every leaf, we perform a potential O(N) operation of copying over the pathNodes
// nodes to a new list to be added to the final pathsList. Hence, the complexity in the worst case could be O(N^2) 

//Space: O(N)