class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] finalArray = new int[nums.length + nums.length];
        for(int i=0;i<nums.length;i++){
            finalArray[i] = nums[i];
            finalArray[nums.length+i] = nums[i];
        }
        return finalArray;
    }
}