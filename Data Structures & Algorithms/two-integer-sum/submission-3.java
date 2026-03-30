class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            while(j<nums.length){
                if(nums[i]+nums[j]==target){
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
                j++;
            }
        }
        return new int[2];
    }
}
