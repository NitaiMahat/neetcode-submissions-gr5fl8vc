class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];

        int prefix = 1;
        for(int i=0;i<nums.length;i++){
            leftArray[i] = prefix;
            prefix *= nums[i]; 
        }
        int suffix = 1;
        for(int i=nums.length-1;i>=0;i--){
            rightArray[i] = suffix;
            suffix *= nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = leftArray[i] * rightArray[i];

        }
        return nums;
    }
}  
