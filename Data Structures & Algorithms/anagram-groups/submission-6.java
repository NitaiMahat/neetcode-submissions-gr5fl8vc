class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String word: strs){
            char[] tempArr = word.toCharArray();
            Arrays.sort(tempArr);
            String newKey = new String(tempArr);
            if(!map.containsKey(newKey)){
                map.put(newKey,new ArrayList<>());
            }
            map.get(newKey).add(word);

        }
        for(List<String> valList: map.values()){
            finalList.add(valList);
        }
        return finalList;
    }
}
