class CheckSecondMax {
    //Returns second maximum value from given Array 
    public static int findSecondMaximum(int[] arr) {
  
      int max = Integer.MIN_VALUE;;
      int secondMax = Integer.MIN_VALUE;
  
      for(int i = 0 ;i<arr.length;i++){
        if(arr[i]>max){
          secondMax= max;
          max=arr[i];
        }
        if(arr[i]>secondMax&&arr[i]!=max){
          secondMax=arr[i];
        }
      }
      return secondMax;
    } //end of findSecondMaximum
    
    public static String arrayToString(int arr[]){
      if (arr.length > 0){
        String result = "";
        for(int i = 0; i < arr.length; i++) {
          result += arr[i] + " ";
        }
        return result;
      }
      else {
        return "Empty Array!";
      }
    }
  
    public static void main(String args[]) {
  
      int[] arr = {-2, -33, -10, -456,-10};
  
      System.out.println("Array: " + arrayToString(arr));
  
      int secMax = findSecondMaximum(arr);
  
      System.out.println("Second maximum: " + secMax);
  
    }
  }