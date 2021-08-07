class Solution 
{
    //Function to find minimum number of pages.
    //Allotment should be in contiguous order
    //Allotment should be in contiguous order
    //Allotment should be in contiguous order
    //GFG omits above, interviewbit okay
    //https://www.interviewbit.com/problems/allocate-books/
    //https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
    public static int findPages(int[]a,int n,int m)
    {
        if(n<m)
            return -1;
        int result=0,sum=0;
        for (int i = 0; i < n; i++)
            sum += a[i];
        int start=a[0],end=sum;
        // finding initial range, check tuf video, 
        // lets say there are three 3 children and 3 books of 12 pages each then
        // max min allocation possible is 12 only
        // lets say 1 book 1 child, then max min possible is that book only
        // so range can be from min value of page to sum of all pages
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(a,n,m,mid)){
                result=mid;
                end=mid-1;
                // this value satisfies the constraint so lets 
                // try find a even smaller max allocation
            }
            else{
                start=mid+1;
                // we are exceeding the max single allocation for this mid, so lets try 
                // for a higher max possible value
            }
        }
        return result;
    }
    private static boolean isPossible(int[]a,int n,int m, int max){
        int allocatedStudents=1,pagesAllocated=0;
        for(int i=0;i<n;i++){
            if(a[i]>max){
                return false;
                // if a single book has more pages than max that can be allocated
            }
            if(pagesAllocated+a[i]>max){
                allocatedStudents++;
                // have to allocate to new student because already exceeded max pages for current
                if(allocatedStudents>m)
                    return false;
                pagesAllocated = a[i];
            }
            else{
                pagesAllocated += a[i];
            }
        }
        return true;
    }
};
// tc: O(NlogN), BS-> logN isPossible: N
// s: O(1), no external space is used