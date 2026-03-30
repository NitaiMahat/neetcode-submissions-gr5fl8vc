class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char letter = s.charAt(i);
            if(map.containsKey(letter)){
                map.put(letter,map.get(letter)+1);
            }else{
                map.put(letter,1);
            }
        }
         Map<Character,Integer> map2 = new HashMap<>();
        for(int j=0;j<s.length();j++){
            char letters = t.charAt(j);
            if(map2.containsKey(letters)){
                map2.put(letters,map2.get(letters)+1);
            }else{
                map2.put(letters,1);
            }
        }
        return map.equals(map2);
    }
}
