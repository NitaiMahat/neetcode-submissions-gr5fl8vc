class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] finalList = new int[nums.length + nums.length];
        for(int i=0;i<nums.length;i++){
            finalList[i]= nums[i];
            finalList[i+nums.length] = nums[i];
        }
        return finalList;
    }
}