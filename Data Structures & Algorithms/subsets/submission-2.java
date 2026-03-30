class Solution {

    /*
    **
    base case
    choice
    constarain
    add
    recurse 
    remove


    */
    List<List<Integer>> finalList = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        subs(new ArrayList<>(),0);
        return finalList;
        
    }
    private void subs( List<Integer> current, int  index){
        if(index==nums.length){
            finalList.add(new ArrayList<>(current));
            return;
        }
       

            current.add(nums[index]);
            subs(current,index+1);
            current.remove(current.size()-1);
            subs(current,index+1);
        
    }
}
