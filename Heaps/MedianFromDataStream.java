class MedianFinder {

    private PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> hi = new PriorityQueue<>();
    private boolean even = true;
    
    public double findMedian() {
       return lo.size()>hi.size() ? lo.peek() : (double)(lo.peek() +hi.peek())/2;
    }
    
    public void addNum(int num) {
       lo.offer(num);
       hi.offer(lo.peek());
       lo.poll();
       if(lo.size()<hi.size()){
           lo.offer(hi.peek());
           hi.poll();
       }
    }}
    //tc o logn n, sc o n
    
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */