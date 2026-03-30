class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return finalList;
    }
    private void backtrack(int[] nums, int index, List<Integer> current){
        if(!finalList.contains(current)){
            finalList.add(new ArrayList<>(current));
        }
        
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums,i+1,current);
            current.remove(current.size()-1);
        }
    }
}
