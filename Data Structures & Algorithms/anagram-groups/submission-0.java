class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String anagram : strs){
            
            char[] charList = anagram.toCharArray();
            Arrays.sort(charList);
            String newString = new String(charList);
            map.putIfAbsent(newString,new ArrayList<>());
            map.get(newString).add(anagram);
        }
        return new ArrayList<>(map.values());
    
    }
}
