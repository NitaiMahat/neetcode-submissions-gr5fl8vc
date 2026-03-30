class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] seen = new int[26];
        for(char letter : s.toCharArray()){
            seen[letter-'a']++;
        }
        for(char l : t.toCharArray()){
            if(seen[l-'a']==0){
                return false;
            }else{
                seen[l-'a']--;
            }
        }
        return true;
    }
}
