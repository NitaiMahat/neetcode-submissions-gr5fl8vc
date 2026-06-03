class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramMap = new HashMap<>();
        for(String currWord : strs){
            char[] charArr = currWord.toCharArray();
              Arrays.sort(charArr);
              String currKey = new String(charArr);
            if(!anagramMap.containsKey(currKey)){
                anagramMap.put(currKey,new ArrayList<>());
            }
            anagramMap.get(currKey).add(currWord);
        }
        List<List<String>> finalList = new ArrayList<>();
        for(String key : anagramMap.keySet()){
            List<String> currList= anagramMap.get(key);
            finalList.add(currList);
        }
        return finalList;
    }
}
