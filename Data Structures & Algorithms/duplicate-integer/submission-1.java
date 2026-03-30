class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int right = i+1;
            while(right!=nums.length){
                 if(nums[i]== nums[right]){
                return true;
                
            }
            right++;

            }
           
        }
        return false;
    }
}