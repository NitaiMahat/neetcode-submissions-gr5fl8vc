class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }
    private int dfs(int[] nums,int target,int index,int currentSum){
        if(index==nums.length){
            if(target==currentSum){
                return 1;
            }
            return 0;
        }

        int add = dfs(nums,target,index+1,currentSum + nums[index]);
        int sub = dfs(nums,target,index+1,currentSum - nums[index]);
        return add+sub;
    }
}
