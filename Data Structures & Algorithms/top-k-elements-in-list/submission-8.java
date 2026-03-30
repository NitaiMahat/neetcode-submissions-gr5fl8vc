class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>  map = new HashMap<>();

        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Set<Integer> keySet = map.keySet();

        for(int key : keySet){
            int value = map.get(key);
            if(bucket[value]==null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        List<Integer> tempList = new ArrayList<>();
        for(int i=bucket.length-1;i>=0 && tempList.size() <k;i--){
            if(bucket[i]!=null){
                   tempList.addAll(bucket[i]);
            }
         
        }

        int[] finalList = new int[tempList.size()];
        for(int i=0;i<tempList.size();i++){
            finalList[i] = tempList.get(i);
        }
        return finalList;
    }
}
