class Solution {
    public int[] productExceptSelf(int[] nums) {
        //prefix suffix method
        int[] leftArr = new int[nums.length];
        int prefix = 1;
        for(int i=0;i<nums.length;i++){
            leftArr[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        int[] rightArr = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            rightArr[i] = suffix;
            suffix *= nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = rightArr[i] * leftArr[i];
        }
        return nums;


    }
}  
