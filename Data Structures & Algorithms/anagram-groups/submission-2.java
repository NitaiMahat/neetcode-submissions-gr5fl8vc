class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] sortList = str.toCharArray();
            Arrays.sort(sortList);
            String sorted = new String(sortList);
            if(map.containsKey(sorted)){
                 List<String> temp = map.get(sorted);
                 temp.add(str);
            }else{
                map.put(sorted,new ArrayList<>());
                List<String> temp = map.get(sorted);
                temp.add(str);
            }
        }
        for(List<String> vals : map.values()){
            finalList.add(vals);
        }
        return finalList;
    }
}
