class Solution {
    public int characterReplacement(String s, int k) {
        int[] storage = new int[26];
        int maxWindow = 0;
        int maxFreq = 0;
        int left =0;
        for(int right=0;right<s.length();right++){
            storage[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,storage[s.charAt(right)-'A']);
            while(right-left+1 - maxFreq >k){
                storage[s.charAt(left)-'A']--;
                left++;
            }
            maxWindow = Math.max(maxWindow,right-left+1);
        }
        return maxWindow;
    }
}
