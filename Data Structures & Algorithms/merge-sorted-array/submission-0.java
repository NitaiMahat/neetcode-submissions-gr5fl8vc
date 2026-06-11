class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=  0;
        while(m<nums1.length){
            nums1[m] = nums2[left];
            left++;
            m++;
        }
        mergeSort(nums1,0,nums1.length-1);
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
    private void merge(int[] nums,int left,int mid, int right){
        ArrayList<Integer> temp = new ArrayList<>();
        int l = left;
        int r = mid+1;
        while(l<=mid && r <=right){
            if(nums[l] > nums[r]){
                temp.add(nums[r]);
                r++;
            }else{
                temp.add(nums[l]);
                l++;
            }

        }
        while(l<=mid){
            temp.add(nums[l]);
            l++;
        }
        while(r<=right){
            temp.add(nums[r]);
            r++;
        }
        for(int i=0;i<temp.size();i++){
            nums[i+left] = temp.get(i);
        }
    }
}