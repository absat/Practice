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
    private HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode startNode = null;
        //adding parents in hashmap with bfs traversal
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left!=null){
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
             if(node.right!=null){
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
            if(node.val==start)
                startNode = node;
        }
        
        //now we will do level order traversal, each traversal burn children(left & right) and parent
        //catch  need to maintain a visited map, why? since node can be from anywhere, if we burnt a
        //parent node from child(which is say starting node), then when burning neighbours of parent node 
        //in next step, we shouldn't burn the child again!
        Set<TreeNode> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);//tricky
        int time=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean burn=false;
            for(int i=0;i<size;i++){
                TreeNode node = queue.remove();
                if(node.left!=null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.add(node.left);
                    burn=true;
                }
                if(node.right!=null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.add(node.right);
                    burn=true;
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    visited.add(parentMap.get(node));
                    queue.add(parentMap.get(node));
                    burn=true;
                }
            }
            if(burn) time++;
            
        }
        return time;

    }
}

//TC O(N), bfs
//SC O(N), queue, visited map, hashmap