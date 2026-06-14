class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String word : wordDict){
            wordSet.add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            for(int j=0 ; j <i;j++){
                String substring = s.substring(j,i);
                if(dp[j] && wordSet.contains(substring)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}
