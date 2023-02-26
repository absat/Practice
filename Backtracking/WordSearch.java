class Solution {
    int rows,cols;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        rows=board.length;
        cols=board[0].length;
        this.board=board;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(backtrack(0,i,j,word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int index, int row, int col, String word){
        if(word.length()<=index)
            return true;
        if(row>=rows||row<0||col<0||col>=cols||this.board[row][col]!=word.charAt(index))
            return false;

        boolean ret = false;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        this.board[row][col] = '#';//setting visited
        for(int[] d:dir){
            ret = backtrack(index+1, row+d[0],col+d[1],word);
            if(ret)
                break;
        }
         this.board[row][col] = word.charAt(index);
         return ret;
    }
}
//TC 4 directions, but we come from one direction, so 3 choices, if grid mXn cells, then O(mn * 3^L)
//SC o(L), l length of word