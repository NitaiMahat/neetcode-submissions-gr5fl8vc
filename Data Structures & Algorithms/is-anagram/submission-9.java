class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.isEmpty() && t.isEmpty()){
            return true;
        }
        int[] letterFrequency = new int[26];
        for(int i=0;i<s.length();i++){
            letterFrequency[s.charAt(i)-'a']++;
            letterFrequency[t.charAt(i)-'a']--;
        }
        for(int i=0;i<letterFrequency.length;i++){
            if(letterFrequency[i] >0){
                return false;
            }
        }
        return true;
    }
}
