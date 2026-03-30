class Solution {
    public int firstUniqChar(String s) {
        Set<Character> seen = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!seen.contains(s.charAt(i)) && !s.substring(i+1,s.length()).contains(String.valueOf(s.charAt(i)))){
                return i;
                
            }
            seen.add(s.charAt(i));
        }
        return -1;
    }
}