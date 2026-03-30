class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(uniqueSet.contains(nums[i])){
                return true;
            }
            uniqueSet.add(nums[i]);
        }
        return false;

        /**
        [1,2,3,3] 3
        set = {1,2,3}

        */

    }
}