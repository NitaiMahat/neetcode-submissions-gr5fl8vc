class Solution {
    private List<List<Integer>> finalList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>());
        return finalList;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> currentList){
        if(target==0){
           
            finalList.add(new ArrayList<>(currentList));
            return;
        }
        if(target<0){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
             if(i>index && candidates[i] == candidates[i-1]){
                continue;
             }
            currentList.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1,currentList);
            currentList.remove(currentList.size()-1);

            
        }
    }
}
