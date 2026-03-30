class Solution {
    public int characterReplacement(String s, int k) {
        int[] seen = new int[26];//cuz upprcase letter only 26;
        int maxWinow = 0; //size of window;
        int maxFreq = 0;
        int left = 0;
        for(int right=0;right<s.length();right++){
            seen[s.charAt(right)- 'A']++;
            maxFreq = Math.max(maxFreq, seen[s.charAt(right)- 'A']);
            while(right-left+1 - maxFreq >k){
                seen[s.charAt(left)-'A']--;
                left++;
            }
            maxWinow = Math.max(maxWinow,right-left+1);

        }
        return maxWinow;
    }
}
