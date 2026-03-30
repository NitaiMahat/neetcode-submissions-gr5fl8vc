class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seenMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(seenMap.containsKey(complement)){
                int[] temp = new int[2];
                temp[1] = i;
                temp[0] = seenMap.get(complement);
                return temp;
            }else{
                seenMap.put(nums[i],i);
            }
        }
        return new int[] {};
    }
}
