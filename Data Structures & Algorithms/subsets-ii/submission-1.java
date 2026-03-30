class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,new ArrayList<>(),0);
       
        return finalList;
    }
    private void backTrack(int[] nums, List<Integer> currentList, int index){
        finalList.add(new ArrayList<>(currentList));
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            currentList.add(nums[i]);
            backTrack(nums,currentList,i+1);
            currentList.remove(currentList.size()-1);
        }

    }
}
