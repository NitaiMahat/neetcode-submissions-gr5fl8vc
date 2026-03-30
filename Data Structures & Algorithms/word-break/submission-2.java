class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //"applepenapple"
        //Set = {'apple','pen','ape'}
        //maxLen = 5

        int maxLen = 0;
        Set<String> set = new HashSet<>(wordDict);
        for(String word : wordDict){
            maxLen = Math.max(maxLen,word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0] = true;

        for(int i=1;i<=n;i++){

            for(int j=i-1;j>= Math.max(0,i-maxLen);j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
        
    }
}
