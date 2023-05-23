class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0, right=matrix.length*matrix[0].length-1;
        while(left<=right){
            int pivotIndex = left +(right-left)/2;
            int pivotElement = matrix[pivotIndex/matrix[0].length][pivotIndex%matrix[0].length];
            if(pivotElement>target)
                right= pivotIndex-1;
            else if(pivotElement<target)
                left= pivotIndex+1;
            else
                return true;
        }
        return false;
    }
}
/*
 * tc o of log(mn)
 * sc o(1)
 */