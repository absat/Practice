class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> tm = new TreeMap();
        for(int n: arr){
            tm.put(n,tm.getOrDefault(n,0)+1);
        }
        for(int x: tm.keySet()){
            if (tm.get(x) == 0) continue;
            int want = x<0?x/2:2*x;
            if(x<0&&x%2!=0 ||  tm.get(x) > tm.getOrDefault(want, 0))
                return false;
            tm.put(want,tm.get(want)-tm.get(x));
        }
        return true;
    }
}