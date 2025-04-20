class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return false;
        List<Integer> inorderList = new ArrayList();
        getInorderList(root,inorderList);
        for(int i=1;i<inorderList.size();i++){
            if(inorderList.get(i)<inorderList.get(i-1))
                return false;
        }
        return true;
    }

    private void getInorderList(TreeNode root, List<Integer> inorderList){
        if(root==null)
            return;
        getInorderList(root.left, inorderList);
        inorderList.add(root.val);
        getInorderList(root.right, inorderList);
    }
}
//tc sc o of n