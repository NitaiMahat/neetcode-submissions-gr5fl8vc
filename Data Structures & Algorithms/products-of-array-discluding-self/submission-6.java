class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int prefix = 1;
        for(int i=0;i<nums.length;i++){
       
            leftProduct[i] = prefix;
                 prefix*= nums[i];
        }
        int[] rightProduct = new int[nums.length];
        int suffix = 1;
        for(int i=nums.length-1;i>=0;i--){
       
            rightProduct[i] = suffix;
                 suffix *= nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = leftProduct[i]*rightProduct[i];
        }
        return nums;
    }
}  
