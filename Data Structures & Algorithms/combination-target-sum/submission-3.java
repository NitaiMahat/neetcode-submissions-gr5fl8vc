class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
      
        backtrack(nums,target,0,new ArrayList<>());
        return finalList;
    }
    private void backtrack(int[] nums, int target, int index, List<Integer> current){
        if(target ==0){
            if(!finalList.contains(current)){
                finalList.add(new ArrayList<>(current));
           
            }
             return;
            
        }
        if(target <0){
            return;
        }
        for(int i=index;i<nums.length;i++){
            
            current.add(nums[i]);
            backtrack(nums,target-nums[i],i,current);
            current.remove(current.size()-1);


        }
    }

}
