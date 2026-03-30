class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int right = i+1;
            while(right<nums.length){
                if(nums[right]==nums[i]){
                    return nums[right];
                }
                right++;
            }
        }
        return 0;
    }
}
