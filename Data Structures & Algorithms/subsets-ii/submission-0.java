class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result,nums,new ArrayList<>(),0);

        return result;
    }
    private void  dfs(List<List<Integer>> result, int[] nums, List<Integer> temp,int index){
        result.add(new ArrayList(temp));
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(result,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
