class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
            333 222   3={3,2} 
        **/
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
            int bucketIndex = freqMap.get(key);
            if(bucket[bucketIndex]==null){
                bucket[bucketIndex] = new ArrayList<>();
            }
            bucket[bucketIndex].add(key);
        }
        List<Integer> tempList = new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                tempList.addAll(bucket[i]);
            }
        }
        int[] finalArr = new int[k];
        for(int i=0;i<finalArr.length;i++){
            finalArr[i] = tempList.get(i);
        }
        return finalArr;

    }
}
