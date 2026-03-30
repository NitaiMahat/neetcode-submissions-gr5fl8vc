class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];    
        if(nums.length==1){
            return nums[0];
        }
        int[] firstDp = new int[nums.length-1];
        int[] secondDp = new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++){
            firstDp[i] = nums[i];
            secondDp[i] = nums[i+1];
        }

        return Math.max(helper(firstDp),helper(secondDp));

    }

    private int helper(int[] nums){
        if(nums.length==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
