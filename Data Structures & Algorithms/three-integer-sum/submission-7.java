class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int mid = i+1;
            int right = nums.length-1;
            while(mid<right){
                int sum = nums[i] + nums[mid] + nums[right];
                if(sum==0){
                    finalList.add(Arrays.asList(nums[i] , nums[mid] ,nums[right]));
                    while(mid<right && nums[mid]==nums[mid+1]){
                        mid++;
                    }
                    while(mid<right && nums[right] == nums[right-1]){
                        right--;
                    }
                     mid++;
                right--;
                }else if(sum>0){
                    right--;
                }else{
                    mid++;
                }
               
            }
        }
        return finalList;
    }
}
