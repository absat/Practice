class Solution {
    
    private List<int[]> getNeighbors(int row, int col, int[][] grid){
        int[][] directions =  new int[][]{{0,-1},{-1,0},{0,1},{1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        List<int[]> next = new ArrayList<>();
        for(int i=0;i<directions.length;i++){
            int nRow = row+ directions[i][0], nCol = col +directions[i][1];
            if(nRow<0 || nCol<0 || nRow>=grid.length || nCol >=grid[0].length || grid[nRow][nCol]!=0)
                continue;
            next.add(new int[]{nRow,nCol});
        }
        return next;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0||grid[grid.length-1][grid[0].length-1]!=0)
            return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        
        //BFS
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            int row = cell[0], col=cell[1];
            int distance  = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for(int[] neighbor: getNeighbors(row,col,grid)){
                int nRow=neighbor[0],cCol = neighbor[1];
                queue.add(new int[]{nRow,cCol});
                grid[nRow][cCol] = distance+1;
            }
        }
        return -1;
    }
}