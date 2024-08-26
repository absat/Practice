class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix[0].length==0)
            return true;
        int r=matrix.length, c= matrix[0].length;
        HashMap<Integer,Integer> diagMap = new HashMap<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int diagonalNumber = i-j;
                if(diagMap.containsKey(diagonalNumber)){
                    if(diagMap.get(diagonalNumber)!=matrix[i][j]){
                        //System.out.println(i+" "+j);
                        return false;
                    }
                } else {
                    diagMap.put(diagonalNumber,matrix[i][j]);
                    //System.out.println(diagonalNumber+" map "+j);
                }
            }
        }
        return true;
    }
}