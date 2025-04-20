class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,maxArea=0;
        while(left<right){
            int width = right-left;
            int height_ = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,height_*width);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}//tc n and sc 1