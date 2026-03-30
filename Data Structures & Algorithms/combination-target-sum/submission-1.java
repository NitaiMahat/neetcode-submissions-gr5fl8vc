class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result,new ArrayList<>(), nums,target,0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int target,int index){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(nums[i]<=target){
                temp.add(nums[i]);
                dfs(result,temp,nums,target-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
