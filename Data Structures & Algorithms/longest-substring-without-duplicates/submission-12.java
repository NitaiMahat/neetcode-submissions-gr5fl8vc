class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int[] freq = new int[127];
        int left = 0;
        for(int i=0;i<s.length();i++){
            while(freq[s.charAt(i)]>0){
                
                freq[s.charAt(left)]--;
                left++;
                
            }
                freq[s.charAt(i)]++;
                int currWindow = i-left+1;
                longest = Math.max(longest,currWindow);
            
        }
        return longest;
    }
}
