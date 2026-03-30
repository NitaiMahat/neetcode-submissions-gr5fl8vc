class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                int[] temp = new int[2];
                temp[1] = i;
                temp[0] = map.get(complement);
                return temp;
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
