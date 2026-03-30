class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i]) && !list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[] finalList = new int[list.size()];
        for(int i=0;i<finalList.length;i++){
            finalList[i] = list.get(i);
        }
        return finalList;
    }
}