class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> finalList = new ArrayList<>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
        }
        List<Integer> firstIndexList = new ArrayList<>();
        List<Integer> secondIndexList = new ArrayList<>();

        for(int nums : nums2){
            if(!map.containsKey(nums) && !secondIndexList.contains(nums)){
                secondIndexList.add(nums);
            }else{
               if(map.containsKey(nums)){
                 map.put(nums,map.get(nums)+1);
               }
                   
                
            
            }
        }
        for(int number : map.keySet()){
            if(map.get(number)==0){
                firstIndexList.add(number);
            }
        }
        finalList.add(firstIndexList);
        finalList.add(secondIndexList);
        return finalList;
    }
}