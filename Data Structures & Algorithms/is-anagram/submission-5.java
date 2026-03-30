class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length()){
            return false;
        }
        int[] seen = new int[26];
        for(int i=0;i<s.length();i++){
            seen[s.charAt(i)-'a']++;
            seen[t.charAt(i)-'a']--;
        }
        
        for(int count:seen){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}
