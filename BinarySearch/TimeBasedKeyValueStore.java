class TimeMap {
    HashMap<String, TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<Integer,String>());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
         if (!map.containsKey(key)) {
            return "";
        }
        Integer floorKey = map.get(key).floorKey(timestamp);
        if(floorKey!=null){
            return map.get(key).get(floorKey);
        }
        return "";
    }
}
//tc m set calls, n get calls, l avg length of key n value strings
//set tc o of M(L + logM), EXPLANATION: have to compare logM NODES(balanced binary tree) of l length, total M times
//get tc o of N(L + logM), treemap order of log n complexity for lookup & insertion, vs o(1) for hashmap, first nllogm for searching the key in first map, second nlogm for search in treemap

//note unique is since key are string we have order l complexity added to hash strings
//sc get constant space as no additional space used, set order of m * l space, as for each value string of length l takes l order of l space
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */