class KthLargest {
    private int k;
    private PriorityQueue<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new PriorityQueue<>();
        for(int num : nums){
            list.offer(num);
            if(list.size()>k){
                list.poll();
            }
        }
    }
    
    public int add(int val) {
        if(list.size()<k){
            list.add(val);
            return list.peek();
        }
        list.add(val);
        list.poll();
        return list.peek();
    }
}
