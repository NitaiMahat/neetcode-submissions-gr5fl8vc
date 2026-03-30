class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result,candidates,target,new ArrayList<>(),0);
        return result;
    }
    private void dfs(List<List<Integer>> result,int[] nums, int target,List<Integer> temp,int index){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if( i > index && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]<=target){
                temp.add(nums[i]);
                dfs(result,nums,target-nums[i],temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
