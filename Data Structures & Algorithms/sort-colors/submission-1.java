class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                mid++;
                left++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,right);
                right--;
            }
        }
    }
    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
         nums[right] = temp;
         
    }
}