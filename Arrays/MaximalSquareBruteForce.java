class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]=='1'){
                   int count=1;
                   boolean stop = false;
                    for(int m=i+1,n=j+1;m<matrix.length && n<matrix[0].length;m++,n++){
                        for(int p=i;p<=m;p++){
                            if(matrix[p][n]!='1'){
                                stop=true;
                                break;
                            }
                        }
                        if(!stop){
                            for(int p=j;p<=n;p++){
                                if(matrix[m][p]!='1'){
                                    stop=true;
                                    break;
                                }
                            }
                            if(!stop){
                                count++;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    max=Math.max(count,max);

               }
           }
       } 
        return max*max;
    }
}
//TC: O((MN)^2)
//SC: O(1) 