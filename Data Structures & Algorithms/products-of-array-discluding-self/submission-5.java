class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArr = new int[nums.length];
        int prefix = 1;
        for(int i=0;i<nums.length;i++){
            leftArr[i] = prefix;
            prefix = prefix * nums[i];       
        }
        int[] rightArr = new int[nums.length];
        int suffix= 1;
        for(int i=nums.length-1;i>=0;i--){
            rightArr[i] = suffix;
            suffix *= nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = leftArr[i] * rightArr[i];
        }
        return nums;
    }
}  
