class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> finalList = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correctIndex = nums[i]-1;

            if(nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(i+1!=nums[i]){
                finalList.add(i+1);
            }
        }
        return finalList;
    }
}