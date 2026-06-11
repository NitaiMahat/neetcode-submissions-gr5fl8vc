class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> seenSet = new HashSet<>();
        int currIndex=0;
        for(int i=0;i<nums.length;i++){
            if(!seenSet.contains(nums[i])){
                seenSet.add(nums[i]);
                nums[currIndex] = nums[i];
                currIndex++;
            }
        }
        return seenSet.size();
    }
}