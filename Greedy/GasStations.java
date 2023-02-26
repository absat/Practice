class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingIndex=0, totalGas=0, currentGas=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i]-cost[i];
            currentGas+=gas[i]-cost[i];
            if(currentGas<0){
                currentGas=0;
                startingIndex=i+1;
            }
        }
        return totalGas>=0 ?  startingIndex:-1;
    }
}
//SC O(1), TC O(N)