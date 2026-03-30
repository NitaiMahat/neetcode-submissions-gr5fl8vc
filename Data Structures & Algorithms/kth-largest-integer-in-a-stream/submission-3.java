class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for(int num :nums){
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }

    }
    
    public int add(int val) {
        if(heap.size()<k){
            heap.add(val);
            return heap.peek();
        }
        heap.add(val);
        heap.poll();

        return heap.peek();
    }
}
