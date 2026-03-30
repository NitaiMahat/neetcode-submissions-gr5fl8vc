class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for(int key : keySet){
            int index = map.get(key);
            if(bucket[index]==null){
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(key);
        }
        List<Integer> tempList = new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                tempList.addAll(bucket[i]);
            }
        }
        int[] finalList = new int[k];
        for(int i=0;i<k;i++){
            finalList[i] = tempList.get(i);
        }
        return finalList;
        
    }
}
