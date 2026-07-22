class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> queue = new ArrayDeque();
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.add(i);
        }
        result[0] = nums[queue.peekFirst()];
        for(int i=k;i<nums.length;i++){
            if(queue.peekFirst() <= i-k){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.add(i);

            result[i-k+1] = nums[queue.peekFirst()];

        }
        return result;
    }
}
