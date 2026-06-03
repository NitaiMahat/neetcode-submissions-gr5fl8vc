class Solution {
    public int[] sortArray(int[] nums) {
       /**
            
       **/
       mergeSort(nums,0,nums.length-1);
       return nums;

}
private void mergeSort(int[] nums,int left,int right){
    if(left>=right){
        return;
    }
    int mid = left+(right-left)/2;
    mergeSort(nums,left,mid);
    mergeSort(nums,mid+1,right);
    merge(nums,left,mid,right);
}
private void merge(int[] nums,int left,int mid,int right){
    ArrayList<Integer> temp = new ArrayList<>();
    int l = left;
    int r = mid+1;
    while(l<=mid && r <=right){
        if(nums[l] <= nums[r]){
            temp.add(nums[l]);
            l++;
        }else{
            temp.add(nums[r]);
            r++;
        }
    }
    while(l <=mid){
        temp.add(nums[l]);
        l++;
    }
    while(r <=right){
        temp.add(nums[r]);
        r++;
    }
    for(int i = left;i<=right;i++){
        nums[i] = temp.get(i-left);
    }
}

}