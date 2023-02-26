class Solution {
    private int[][] board;
    private int n=3;
    
    public String tictactoe(int[][] moves) {
        board = new int[n][n];
        int player = 1,c=0;
        
        //for each move
        for(int[] move: moves){
            int row = move[0], col = move[1];
            board[row][col] = player;
            if(checkRow(row,player) || checkCol(col,player) || (row == col && checkDiagonal(player)) || 
              ( row+col == n-1 && checkAntiDiagonal(player))){
                return player == 1 ? "A":"B";
            }
            player*=-1;
            System.out.println("count="+(c++));
        }
        return moves.length == n*n?"Draw":"Pending";
    }
    
    private boolean checkRow(int row, int player){
        for(int i=0;i<n;i++){
            if(board[row][i]!=player)
                return false;

            }
        return true;
    }
    
    private boolean checkCol(int col, int player){
        for(int i=0;i<n;i++){
            if(board[i][col]!=player)
                return false;
            }

        return true;
    }
    
     private boolean checkDiagonal(int player){
        for(int i=0;i<n;i++){
            if(board[i][i]!=player)
                return false;
            }

        return true;
    }
    
     private boolean checkAntiDiagonal(int player){
        for(int i=0;i<n;i++){
            if(board[i][n-1-i]!=player)
                return false;
            }

        return true;
    }
}
//tc o(mn) where n moves
//sc o(n^2)