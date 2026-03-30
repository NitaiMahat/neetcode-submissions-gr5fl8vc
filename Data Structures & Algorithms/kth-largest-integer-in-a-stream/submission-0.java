class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.add(val);
            return minHeap.peek();
        }
        minHeap.add(val);
        minHeap.poll();
        return minHeap.peek();
        
    }
}
