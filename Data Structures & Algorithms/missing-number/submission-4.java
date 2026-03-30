class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        for(int i=0;i<nums.length;i++){
            length +=  i -nums[i];
        }
        return length;
    }
}
