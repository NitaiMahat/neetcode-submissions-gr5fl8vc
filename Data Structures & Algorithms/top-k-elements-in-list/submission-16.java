class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for(int num:nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num,freqMap.get(num)+1);
            }else{
                freqMap.put(num,1);
            }
        }
        for(int key :freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> temp = new ArrayList<>();
        int[] finalList =new int[k];
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                 temp.addAll(bucket[i]);
            }
           
        }
        for(int i=0;i<finalList.length;i++){
            finalList[i] = temp.get(i);
        }
        return finalList;
    }
}
