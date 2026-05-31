### Question Find max depth of binary tree
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Note for a single node tree, depth is 1.**
- Time complexity:
<!-- Add your time complexity here, e.g. O(n) -->
O(n), visit every node once
- Space complexity:
<!-- Add your space complexity here, e.g. O(n) -->
O(n), for dfs call stack, for bfs queue storage

#### DFS
```java []
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
    public int maxDepth(TreeNode root) {
        return solve(root);
    }

    private int solve(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(solve(root.left),solve(root.right)) + 1;
    }
}
```

#### BFS
```
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
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int depth=0;
        while(queue.size()>0){
            depth++;
            int size = queue.size();//tricky, w/o this logic will fail as and when queue is modified
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }
}
```

### Question Zig zag level order traversal

- Time complexity:
<!-- Add your time complexity here, e.g. O(n) -->
O(n), visit nodes once and insertion to queue whether head or tail is constant time

- Space complexity:
<!-- Add your space complexity here, e.g. O(n) -->
O(n) for queue

# Code
```java []
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
        List<List<Integer>> list = new LinkedList();
        if(root==null){
            return list;
        }
        //Maintain a flag reverse to decide if elements are stored in left to right or right to left order in result list.
        //If reverse order, add element to head of list instead of tail
        boolean reverse = false;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> subList = new LinkedList();
            for(int i=0; i< size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                 if(node.right!=null){
                    queue.offer(node.right);
                }
                if(reverse){
                    subList.addFirst(node.val);
                }
                else{
                    subList.add(node.val);
                }
            }
            list.add(subList);
            reverse = !reverse;
        }
        return list;        
    }
}
```


