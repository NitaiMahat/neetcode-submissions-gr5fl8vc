class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productLeft = new int[nums.length];
        int[] productRight = new int[nums.length];

        productLeft[0] = 1;
        for(int i=1;i<nums.length;i++){
            productLeft[i] = nums[i-1] * productLeft[i-1];
        }

        productRight[productRight.length-1] = 1;
        for(int i=productRight.length-2;i>=0;i--){
            productRight[i] = nums[i+1] * productRight[i+1];
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = productLeft[i] * productRight[i];
        }
        return nums;
    }
}  
