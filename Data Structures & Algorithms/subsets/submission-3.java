class Solution {
    private List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> current = new ArrayList<>();
        dfs(nums,current,0);
        return finalList;
    }
    private void dfs(int[] nums,List<Integer> current, int index){
        if(nums.length == index){
            finalList.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        dfs(nums,current,index+1);
        current.remove(current.size()-1);
        dfs(nums,current,index+1);
    }
}
