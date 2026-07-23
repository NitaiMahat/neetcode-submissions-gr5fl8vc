class Solution {
    List<List<Integer>> finalList=  new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> current = new ArrayList<>();
        dfs(nums,current,target,0);
        return finalList;
    }
    private void dfs(int[] nums,List<Integer> current, int target,int index){
        if(target==0){
            finalList.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || index==nums.length){
            return;
        }
        current.add(nums[index]);
        dfs(nums,current,target-nums[index],index);
        current.remove(current.size()-1);
        dfs(nums,current,target,index+1);


    }
}
