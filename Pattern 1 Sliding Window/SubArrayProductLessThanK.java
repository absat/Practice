public class SubArrayProductLessThanK {
    public static void main(String[] args){
        int[] arr = {10,5 ,2 ,6 };
        int k=100;
        System.out.println(solve(arr,k));
    }

    private static int solve(int[] arr, int k){
        if(k<1)
            return 0;
        int left = 0, right = 0, count = 0, product =1;
        for(right = 0; right<arr.length; right++){
            product *= arr[right];
            while(product>k){
                if(arr[left]!=0){
                    product /= arr[left];
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
