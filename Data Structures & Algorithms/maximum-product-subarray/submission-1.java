class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null){
            return 0;
        }
        int globalMax = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        
        for(int i = 1;i<nums.length;i++){
            int num = nums[i];
            int prevMax = localMax;
            int prevMin = localMin;
            localMax = Math.max(num,Math.max(num * prevMax,num* prevMin));
            localMin = Math.min(num,Math.min(num * prevMax,num * prevMin));
            globalMax = Math.max(globalMax,localMax);
        }
        return globalMax;

    }
}
