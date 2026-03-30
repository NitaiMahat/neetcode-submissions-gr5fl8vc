class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] alphaCount = new int[26];

        for(int i=0;i<s.length();i++){
            alphaCount[s.charAt(i)-'a']++;
            alphaCount[t.charAt(i)-'a']--;
        }

        for(int count: alphaCount){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}
