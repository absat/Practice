
public class InorderSuccessorBT {
    public static void solve(TreeNode node, TreeNode p){
        if(p.right!=null){
            while(p.left!=null)
                p=p.left;
            System.out.println(p.val);
            return;
        }
        while(p.parent!=null&&p.parent.right==p){
            p=p.parent;
        }
        System.out.println(p.parent==null?null:p.parent.val);
    }
    
    public static void main(String[] args){
    /*
        25(4) 
		/    \
	 20(2)   13(0)
	 /  \
  1(0)  4(0) 
   */
        TreeNode node1 = new TreeNode(1,null,null,null);
        TreeNode node4 = new TreeNode(4,null,null,null);
        TreeNode node20 = new TreeNode(20,node1,node4,null);
        TreeNode node13 = new TreeNode(13,null,null,null);
        TreeNode node = new TreeNode(25,node20,node13,null);
        node13.parent=node;
        node20.parent=node;
        node4.parent=node20;
        node1.parent=node20;

        // inorderTraversal(node);//1 20 4 25 13 
        System.out.println("successor 13: ");
        solve(node,node13);
        System.out.println("successor 4: ");
        solve(node,node4);
        System.out.println("successor 1: ");
        solve(node,node1);
    }

    //Time:O(H)


}
