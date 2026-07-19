class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
         if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        dp2[1] = nums[1];
        dp2[2] = Math.max(dp2[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            dp2[i] = Math.max(nums[i]+dp2[i-2],dp2[i-1]);
        }
        return Math.max(dp2[nums.length-1],dp[nums.length-2]);

    }
}
