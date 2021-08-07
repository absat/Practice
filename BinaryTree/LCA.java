/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
final class LCA{
    public TreeNode lca;
    public int elementsFound;
    public LCA(TreeNode lca, int elementsFound){
        this.lca = lca;
        this.elementsFound = elementsFound;
    }
}
class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCAHelper(root, p, q).lca;
    }
    private LCA LCAHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return new LCA(null,0);
        LCA leftResult = LCAHelper(root.left,p,q);
        if(leftResult.elementsFound==2)
            return leftResult;
        LCA rightResult = LCAHelper(root.right,p,q);
        if(rightResult.elementsFound==2)
            return rightResult;
        int numNodes = leftResult.elementsFound+rightResult.elementsFound+(root==p?1:0)+(root==q?1:0);
        return new LCA(numNodes==2?root:null,numNodes);
    }
}