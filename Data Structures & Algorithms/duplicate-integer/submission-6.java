class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seenSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(seenSet.contains(nums[i])){
                return true;
            }
            seenSet.add(nums[i]); 
        }
        return false;
    }
}