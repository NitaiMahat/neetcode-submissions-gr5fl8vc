class Solution {
    public int search(int[] nums, int target) {
        int pivotIndex = nums.length-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                pivotIndex = i;
            }
        }
        return Math.max(binarySearch(nums,0,pivotIndex,target), binarySearch(nums,pivotIndex+1,nums.length-1,target));
    }
    private int binarySearch(int[] nums, int left,int right,int target){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
