class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] list = new int[26];
        for(int i=0;i<magazine.length();i++){
            list[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            list[ransomNote.charAt(i)-'a']--;
        }
        for(int i=0;i<list.length;i++){
            if(list[i] <0){
                return false;
            }
        }
        return true;
    }
}