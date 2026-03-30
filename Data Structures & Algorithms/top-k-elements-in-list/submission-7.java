class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Set<Integer> keySet = map.keySet();
        for(int number : keySet){
            int indexValue = map.get(number);
            if(bucket[indexValue]==null){
                bucket[indexValue] =  new ArrayList<>();
            }
            bucket[indexValue].add(number);
        }

        List<Integer> tempList = new ArrayList<>();
        for(int m=bucket.length-1;m>=0&& tempList.size() <k ;m--){
            if(bucket[m]!=null){
                tempList.addAll(bucket[m]);
            }
        }
        int[] finalList = new int[k];
        for(int n=0;n<k;n++){
            finalList[n] = tempList.get(n);
        }
        return finalList;
    }
}
