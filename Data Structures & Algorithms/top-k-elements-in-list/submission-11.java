class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] finalList = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Set<Integer> keySet = map.keySet();
        for(int key : keySet){
            int index = map.get(key);
            if(bucket[index]==null){
                bucket[index]= new ArrayList<>();
            }
            bucket[index].add(key);
        }

        List<Integer> tempList = new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                tempList.addAll(bucket[i]);
            }
        }
        for(int i=0;i<k;i++){
            finalList[i] = tempList.get(i);
        }
        return finalList;

    }
}
