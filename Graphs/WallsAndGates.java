class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0)
                    queue.add(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int[] neighbours: getNeighbors(node[0],node[1],rooms)){
                int r=neighbours[0],c=neighbours[1];
                rooms[r][c]=rooms[node[0]][node[1]]+1;
                queue.offer(new int[]{r,c});
            }
        }
        
    }
    private List<int[]> getNeighbors(int x, int y, int[][] rooms){
        List<int[]> neighbors = new ArrayList<>();
        int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for(int[] d: directions){
            int r = x+d[0], c= y+d[1];
            if(r<0 || c<0 || r>=rooms.length || c>=rooms[0].length || rooms[r][c]!=Integer.MAX_VALUE)
                continue;
            neighbors.add(new int[]{r,c});
        }
        return neighbors;
    }
}