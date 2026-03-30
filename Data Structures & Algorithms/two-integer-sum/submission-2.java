class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] finalList = new int[2];
        for(int i=0;i<nums.length;i++){
            int right = nums.length-1; 
            while(i<right){
            int sum = nums[i]+nums[right];
            if(sum==target){
                finalList[0]= i;
                finalList[1] = right;
                return finalList;
            }
            right--;
            }
        }
       
          return finalList;
    }
        
    
}
