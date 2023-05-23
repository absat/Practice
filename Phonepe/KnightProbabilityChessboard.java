class Solution {
    public double knightProbability(int N, int k, int row, int column) {
        double[][] dp = new double[N][N];
        dp[row][column]=1;
        int[] dr = new int[]{1,1,2,2,-1,-1,-2,-2};
        int[] dc = new int[]{2,-2,1,-1,2,-2,1,-1};

        for(;k>0;k--){
            double[][] dp2 = new double[N][N];
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    for(int kk=0;kk<8;kk++){
                        int newr=r+dr[kk];
                        int newc=c+dc[kk];
                        if(newr>=0 && newr<N && newc>=0 && newc<N){
                            dp2[newr][newc]+=dp[r][c]/8.0;
                        }
                    }
                }
            }
            dp=dp2;
        }

        double ans=0.0;
        for(double[] rW: dp){
            for(double val: rW)
                ans+=val;
        }
        return ans;
    }
}
// tc o (nsquare * k), sc o nsquare