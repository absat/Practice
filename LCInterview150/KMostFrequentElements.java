class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));
        int i = nums.length;
        for(Map.Entry<Integer,Integer> entry: hm.entrySet())
        {          
            queue.offer(entry.getKey());
            if(queue.size()>k)
                queue.poll();
        }
        int[] result = new int[k];
        i=0;
        while(queue.size()>0){
            result[i++] = queue.poll();
        }
        return result;
    }
}//tc nlogk
//sc o n+k