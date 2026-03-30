class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s+");
        String temp = words[words.length-1];
        return temp.length();
    }
}