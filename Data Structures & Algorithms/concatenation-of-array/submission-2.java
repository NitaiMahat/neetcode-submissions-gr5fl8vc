class Solution {
    public int[] getConcatenation(int[] nums) {
        /**
            nums = [1,8,5,2]
            ans =[ 1,8 ,5 ,1 ,1,8 , , ]
                  1 2 3 4 5 6 7 8
        **/
        int[] ans = new int[nums.length + nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i];
            ans[i+nums.length] = nums[i];
        }
        return ans;
    }
}