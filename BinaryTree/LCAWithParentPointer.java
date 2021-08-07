/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int depth0=getDepth(p), depth1=getDepth(q);
        //Let's always keep the deeper node at p
        if(depth0<depth1){
            Node temp = p;
            p=q;
            q=temp;
        }
        int diff=Math.abs(depth0-depth1);
        while(diff!=0){
            p=p.parent;
            diff--;
        }
        while(p!=q){
            p=p.parent;
            q=q.parent;
        }
        return p;
    }
    public int getDepth(Node node){
        int depth=0;
        while(node.parent!=null){
            node = node.parent;
            depth++;
        }
        return depth;
    }
}