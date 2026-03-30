class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //base = integer in an array sum up to target 
        //reapeatation is allowed  same frency is not allowed

        backtrack(nums,target,new ArrayList<>(),0);
        return result;

    }
    public void backtrack(int[] nums,int target, List<Integer> currentList,int index){
        if(target==0){
            result.add(new ArrayList<>(currentList));
            return;
        }
        if(target < 0){
            return;
        }
       
        for(int i=index;i<nums.length;i++){
            currentList.add(nums[i]);
            backtrack(nums,target-nums[i],currentList,i);
             currentList.remove(currentList.size()-1);
             
        }
       
    }
}
