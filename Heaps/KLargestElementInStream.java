class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int k =0;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int a:nums){
            add(a);
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 //use min heap fro k largest, tc: order of  nlogk + order of m logk
 //tc generally for this type of qwues order of n logk
 //sc o of k