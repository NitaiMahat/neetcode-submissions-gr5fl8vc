class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] sub1 = Arrays.copyOfRange(nums,1,nums.length);
        int[] sub2 = Arrays.copyOfRange(nums,0,nums.length-1);

        return Math.max(helper(sub1),helper(sub2));

    }
    private int helper(int[] num){
        int rob1 = 0;
        int rob2 = 0;
        for(int n:num){
            int temp = Math.max(rob1 + n,rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
