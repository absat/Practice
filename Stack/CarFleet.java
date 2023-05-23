class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> m = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++){
            m.put(position[i],(double)(target-position[i])/speed[i]);
        }
        int res=0;
        double cur=0;
        for(double time: m.values()){
            System.out.println(time);
            if(time>cur){
                cur=time;
                res++;
            }
        }
        return res;
    }
}
//tc o logn +o n so o of n log n, as treemap insertion o of log n
//sc n?