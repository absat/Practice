class RearrangeSortedArrayMaxMin {

    public static void maxMin(int[] arr) {
     
      int mini=0,maxi=arr.length-1,max=arr[maxi]+1;
      for( int i = 0; i < arr.length; i++) {
        if(i%2==0){
            arr[i]+=(arr[maxi]%max)*max;
            maxi--;
        }
        else{
            arr[i]+=(arr[mini]%max)*max;
            mini++;
        }
      }
      for( int i = 0; i < arr.length; i++) {
        arr[i] = arr[i] / max;
      }
    }
  
    public static void main(String args[]) {
  
      int[] arr = {1,2,3,4,6,7,8,9};
      System.out.print("Array before min/max: ");
      for (int i = 0; i < arr.length; i++) 
        System.out.print(arr[i] + " ");
      System.out.println();
  
      maxMin(arr);
  
      System.out.print("Array after min/max: ");
      for (int i = 0; i < arr.length; i++) 
        System.out.print(arr[i] + " ");
      System.out.println();
    }
  }