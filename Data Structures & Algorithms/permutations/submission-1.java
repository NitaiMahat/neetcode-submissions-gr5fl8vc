class Solution {
    private List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new ArrayList<>());
        return finalList;
    }
    private void backtrack(int[] nums, List<Integer> currentList){
        if(currentList.size()==nums.length){
            finalList.add(new ArrayList<>(currentList));
            return;
        }
      
        for(int i=0;i<nums.length;i++){
              if(currentList.contains(nums[i])){
                continue;
            }
            currentList.add(nums[i]);
            backtrack(nums,currentList);
            currentList.remove(currentList.size()-1);
       
        }
    }

}
