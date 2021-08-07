//https://leetcode.com/discuss/interview-question/479911/GoogleorPhoneorFind-nth-node-in-inorder-traversal

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int size;
    TreeNode parent;


    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right,int size) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.size = size;
    }

    TreeNode(int val, TreeNode left, TreeNode right,TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

public class KthNodeInorderTraversal {
    public static TreeNode solve(TreeNode node, int k){
        TreeNode iter = node;
        while(iter!=null){
            int leftSize = iter.left!=null?iter.left.size+1:0;//error in EPI, +1 correct
            if(leftSize+1<k){
                k-=(leftSize+1);
                iter=iter.right;
            }
            else if(leftSize+1==k)
                return iter;
            else{
                iter=iter.left;
            }
        }
        // If k is between 1 and the tree size, this line is unreachable .
        return null;
    }
    
    public static void main(String[] args){
    /*
        25(4) 
		/    \
	 20(2)   13(0)
	 /  \
  1(0)  4(0) 
   */
        TreeNode node1 = new TreeNode(1,null,null,0);
        TreeNode node4 = new TreeNode(4,null,null,0);
        TreeNode node20 = new TreeNode(20,node1,node4,2);
        TreeNode node13 = new TreeNode(13,null,null,0);
        TreeNode node = new TreeNode(25,node20,node13,4);
        // inorderTraversal(node);//1 20 4 25 13 
        System.out.println("k=1: "+solve(node,1).val);
        System.out.println("k=2: "+solve(node,2).val);
        System.out.println("k=3: "+solve(node,3).val);
        System.out.println("k=4: "+solve(node,4).val);
        System.out.println("k=5: "+solve(node,5).val);
    }

    //Time:O(H)

    // public static void inorderTraversal(TreeNode root) {
    //     Deque<TreeNode> stack = new LinkedList<TreeNode>();
    //     List<Integer> ans = new ArrayList<Integer>();
    //     TreeNode curr = root;
    //     while(!stack.isEmpty()||curr!=null){
    //         if(curr!=null){
    //             stack.addFirst(curr);
    //             curr=curr.left;
    //         }
    //         else{
    //             curr = stack.removeFirst();
    //             ans.add(curr.val);
    //             curr=curr.right;
    //         }            
    //     }
    //     for(int i: ans)
    //        System.out.print(i+" ");
    //     System.out.println("\n");
    // }
}
