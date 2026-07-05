class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new int[]{};
        }
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){

            if(freqMap.containsKey(num)){
                freqMap.put(num,freqMap.get(num)+1);
            }else{
                freqMap.put(num,1);
            }
        }
        for(int key : freqMap.keySet()){
            if(bucket[freqMap.get(key)]==null){
                bucket[freqMap.get(key)] = new ArrayList<>();
            }
            bucket[freqMap.get(key)].add(key);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                temp.addAll(bucket[i]);
            }
        }
        int[] finalArr = new int[k];
        for(int i=0;i<k;i++){
            finalArr[i] = temp.get(i);
        }
        return finalArr;

    }
}
