class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(freqMap.containsKey(nums[i])){
                freqMap.put(nums[i],freqMap.get(nums[i])+1);
            }else{
                freqMap.put(nums[i],1);
            }
        }
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] finalArr = new int[k];
        int counter = 0;
        for(int i=bucket.length-1;i>=0&& counter <k;i--){
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
