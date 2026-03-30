class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //[1,2,2,3,3,3] k=2
        //[1,2,3,3,4,4,5,5] k =2
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Set<Integer> keySet = map.keySet();
        for(int key:keySet){
            int value = map.get(key);
            if(bucket[value]==null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        List<Integer> tempList = new ArrayList<>();
        for(int i=bucket.length-1;i>=0 && tempList.size()<k;i--){
            if(bucket[i]!=null){
                tempList.addAll(bucket[i]);
            }
        }
        int[] result = new int[k];
        for(int i =0;i<k;i++){
            result[i] = tempList.get(i);
        }
        return result;




    }
}
