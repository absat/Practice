### Invert Binary Tree
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
     public TreeNode invertTree(TreeNode root) {
        /*
        Recursive solution. Complexity: o(n) time, o(n) space for call stack for worst case

        if(root==null)
            return null;
        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);

        root.right = newRight;
        root.left = newLeft;
        return root;
        */

        Queue<TreeNode> queue = new LinkedList();
        if(root==null)
            return null;

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

        return root;
    }


}
```
### Max depth of binary tree
Time complexity:
O(n), visit every node once

Space complexity:
O(n), for dfs call stack, for bfs queue storage
```
Code for DFS
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
Code for BFS
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

### Diameter of Binary Tree
```
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        solve(root);
        return diameter;
    }

    private int solve(TreeNode root){
        if(root == null)
            return 0;
        int leftPath = solve(root.left);
        int rightPath = solve(root.right);

        diameter = Math.max(diameter, leftPath+rightPath);//note we dont do leftpath+rightPath + 2 as we are going with depth at each node level so edge from either child to parent is already accounted for

        return Math.max(leftPath,rightPath)  + 1;//calculating depth, need to go with max of either child
    } 
       
}

```

### Maximum path sum of binary tree

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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    private int solve(TreeNode root){
        if(root==null)
            return 0;
        int leftSum = Math.max(0,solve(root.left));
        int rightSum = Math.max(0,solve(root.right));

        max = Math.max(max, leftSum + rightSum + root.val);

        return  Math.max(leftSum,rightSum) + root.val;
    }
}
```

### Subtree of another tree
```/**
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
       // CONSTANTS
    final int MOD_1 = 1000000007;
    final int MOD_2 = 2147483647;

    List<long[]> memo = new ArrayList();

    //Hashing a node
    long[] hashSubtreeAtNode(TreeNode node, boolean needToAdd){
        if(node==null){
            return new long[]{3,7};
        }

        long[] left = hashSubtreeAtNode(node.left, needToAdd);
        long[] right = hashSubtreeAtNode(node.right, needToAdd);

        long left1 = (left[0]<<5) % MOD_1;
        long right1 = (right[0]<<1) % MOD_1;

        long left2 = (left[1]<<7) % MOD_2;
        long right2 = (right[1]<<1) % MOD_2;

        long[] hashpair = { (left1 + right1 +node.val) % MOD_1,
                        (left2 + right2+node.val) % MOD_2};

        if(needToAdd){
            memo.add(hashpair);
        }

        return hashpair;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        hashSubtreeAtNode(root, true);

        long[] s = hashSubtreeAtNode(subRoot,false);

        for(long[] hashes: memo){
            if(hashes[0]==s[0] && hashes[1]==s[1]){
                return true;
            }
        }

        return false;
    }
}
```

### LCA of Binary Tree
```
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.solve(root,p,q);
        return lca;
    }

    boolean solve(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return false;

        int left = solve(root.left,p,q)?1:0;
        int right = solve(root.right,p,q)?1:0;

        int mid = (root==p || root==q) ? 1:0;

        if(mid + left + right >=2){
            this.lca = root;
        }

        return mid + left + right>0;

    }
}
```

### LCA OF BST

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         int parentVal = root.val;

         int pVal = p.val;
         int qVal = q.val;

         if(pVal> parentVal && qVal>parentVal){
            return lowestCommonAncestor(root.right, p, q);
         } else if(pVal< parentVal && qVal<parentVal){
            return lowestCommonAncestor(root.left, p, q);
         } else{
            return root;
         }
    }
}
```
