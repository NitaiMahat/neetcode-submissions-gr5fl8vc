class Solution {
    public int findKthLargest(int[] nums, int k) {
        //array deque
        /**
            2,3,1,5,4  k=2
            5,4

            2,3,1,1,5,5,4
            5,5,4
            queue.minheap = 
        **/
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
            queue.add(num);

            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
