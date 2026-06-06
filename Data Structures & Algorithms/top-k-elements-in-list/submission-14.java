class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //bucketSort;
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num :nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num,freqMap.get(num)+1);
            }else{
                freqMap.put(num,1);
            }
        }

        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] finalArr = new int[k];
        int counter=0;
        for(int i=bucket.length-1;i>=0 && counter <k;i--){
            if(bucket[i]!=null){
                for(int num : bucket[i]){
                    finalArr[counter] = num;
                    counter++;
                }
            }
        }
        return finalArr;
    }
}
