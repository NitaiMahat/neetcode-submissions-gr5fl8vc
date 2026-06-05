class Solution {
    public int subarraySum(int[] nums, int k) {
        int currentSum =0;
        int totalSum = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        for(int num : nums){
            currentSum += num;
            int temp = currentSum -k;
            if(countMap.containsKey(temp)){
                totalSum += countMap.get(temp);
                
            }
            if(countMap.containsKey(currentSum)){
                countMap.put(currentSum,countMap.get(currentSum)+1);
            }else{
                countMap.put(currentSum,1);
            }
        }
        return totalSum;
    }
}