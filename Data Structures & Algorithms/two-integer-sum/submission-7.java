class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] finalArray = new int[2];
        //Set<Integer> seenSet = new HashSet<>();
        Map<Integer,Integer> seenMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(seenMap.containsKey(complement)){
                finalArray[0] = seenMap.get(complement);
                finalArray[1] = i;
                return finalArray;
            }
            seenMap.put(nums[i],i);
        }
        return finalArray;
    }
}
