class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList  = new ArrayList<>();
        Map<String,List<String>> anagramMap = new HashMap<>();
        for(String word : strs){
            char[] tempArr = word.toCharArray();
            Arrays.sort(tempArr);
            String tempString = new String(tempArr);
            if(!anagramMap.containsKey(tempString)){
                anagramMap.put(tempString,new ArrayList<>());
            }
            anagramMap.get(tempString).add(word);

        }
        for(List<String> groupList : anagramMap.values()){
            finalList.add(groupList);
        }
        return finalList;
    }
}
