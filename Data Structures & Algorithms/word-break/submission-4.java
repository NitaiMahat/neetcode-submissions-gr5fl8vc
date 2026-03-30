class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(String word : set){
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i=1;i<=s.length();i++){
            for(int j= i-1;j>= Math.max(0,i - maxLen);j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
