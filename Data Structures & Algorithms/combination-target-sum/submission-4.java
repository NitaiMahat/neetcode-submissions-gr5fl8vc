class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
         dfs(nums,target,0);
         return finalList;
    }
    private void dfs(int[] nums,int remaining,int index){
        if(remaining==0){
            finalList.add(new ArrayList<>(currentList));
            return;
        }
        if(remaining <0  || index == nums.length){
            return;
        }
        currentList.add(nums[index]);
        dfs(nums,remaining-nums[index],index);
        currentList.remove(currentList.size()-1);
        dfs(nums,remaining,index+1);

    }
}
