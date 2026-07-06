class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(left < nums1.length && right < nums2.length){
            if(nums1[left] >= nums2[right]){
                temp.add(nums2[right]);
                right++;
            }else{
                temp.add(nums1[left]);
                left++;
            }
        }
        while(left<nums1.length){
            temp.add(nums1[left]);
            left++;
        }
        while(right<nums2.length){
            temp.add(nums2[right]);
            right++;
        }
        if(temp.size() %2==0){
            int a = temp.get(temp.size()/2);
            int b = temp.get((temp.size()/2)-1);
            return (double) (a+b)/2.0;
        }
        return (double) temp.get(temp.size()/2);
    }
}
