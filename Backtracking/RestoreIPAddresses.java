class Solution {
    private String s;
    private int n;
    private List<String> result = new ArrayList<>();
    private List<String> segments = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        this.s=s;
        backtrack(-1,3);
        return result;
    }

    private void backtrack(int prevPos, int dots){
        /*
          prevPos : the position of the previously placed dot
          dots : number of dots to place
        */
        // The current dot currPos could be placed 
        // in a range from prevPos + 1 to prevPos + 4.
        // The dot couldn't be placed 
        // after the last character in the string.
        int maxPos = Math.min(n-1, prevPos+4);
        for(int currPos = prevPos+1;currPos<maxPos;currPos++){
            String segment = s.substring(prevPos+1,currPos+1);
            if(valid(segment)){
                segments.add(segment);//place dot
                if(dots-1==0){//all 2 dots placed
                    updateSegment(currPos);//add solution to output
                }
                else{
                    backtrack(currPos,dots-1);//continue to place dots
                }
                segments.remove(segments.size()-1);
            }
        }
    }

    private boolean valid(String segment){
        /*
          Check if the current segment is valid :
          1. less or equal to 255      
          2. the first character could be '0' 
          only if the segment is equal to '0'
        */
        int m = segment.length();
        if(m>3)
            return false;
        return (segment.charAt(0)!='0') ? (Integer.valueOf(segment)<256) : (m==1);  
    }

    private void updateSegment(int currPos){
        /*
          updateSegment will append the current list of segments 
          to the list of result.
        */
        String segment = s.substring(currPos+1,n);
        if(valid(segment)){//why the extra check here? we still need to validate and add the last segment after the last dot right,ege 255.255.255.251, 251 in the last segment
            segments.add(segment);
            String ip = String.join(".", segments);
            result.add(ip);
            segments.remove(segments.size()-1);
        }

    }
}
//TC O(1) since we check only 3^3 = 27 solutions
//SC constant as we can have max 19 ip addresses