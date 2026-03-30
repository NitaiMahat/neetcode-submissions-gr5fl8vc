class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] indexMap = new int[27];
        for(int i=0;i<s.length();i++){
            indexMap[s.charAt(i) - 'a']++;
            indexMap[t.charAt(i)-'a']--;

        }
        for(int i=0;i<indexMap.length;i++){
            if(indexMap[i] != 0){
                return false;
            }
        }
        return true;
    }
}
