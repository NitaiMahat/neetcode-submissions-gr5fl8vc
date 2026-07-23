class Solution {
    List<List<Integer>> finalList = new ArrayList<>();
   
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        if(candidates.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<Integer> currList = new ArrayList<>();
        dfs(candidates,currList,target,0);
        return finalList;
        
    }
    private void dfs(int[] candidates,List<Integer> currList,int target,int index){
        if(target==0){
           
            
                finalList.add(new ArrayList<>(currList));
            
            return;
        }
        if(target<0 || index==candidates.length){
            return;
        }
        
        currList.add(candidates[index]);
        
        dfs(candidates,currList,target-candidates[index],index+1);
        currList.remove(currList.size()-1);
        int nextIndex = index+1;
        while(nextIndex < candidates.length && candidates[nextIndex]== candidates[index]){
            nextIndex++;
        }
         dfs(candidates,currList,target,nextIndex);
      
         
    }
}
