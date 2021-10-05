class Solution {
    int max = Integer.MIN_VALUE, start=0,end=0;
public String longestPalindrome(String st) {
        

 Integer[][] dp = new Integer[st.length()][st.length()];
    findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    return st.substring(start,end+1);
  }

  private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
    if (startIndex > endIndex)
      return 0;

    // every string with one character is a palindrome
    if (startIndex == endIndex){
         if(1>max){
            max = 1;
            start = startIndex;
            end=endIndex;
        }
      return 1;
    }

    if (dp[startIndex][endIndex] == null) {
      // case 1: elements at the beginning and the end are the same
      if (st.charAt(startIndex) == st.charAt(endIndex)) {
        int remainingLength = endIndex - startIndex - 1;
        // check if the remaining string is also a palindrome
        if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
          dp[startIndex][endIndex] = remainingLength + 2;
            if(dp[startIndex][endIndex]>max){
                max = dp[startIndex][endIndex];
                start = startIndex;
                end=endIndex;
            }
          return dp[startIndex][endIndex];
        }
      }

      // case 2: skip one character either from the beginning or the end
      int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
      int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
      dp[startIndex][endIndex] = Math.max(c1, c2);
     if(dp[startIndex][endIndex]>max){
            max = dp[startIndex][endIndex];
            start = startIndex;
            end=endIndex;
        }
    }

    return dp[startIndex][endIndex];
  }
}