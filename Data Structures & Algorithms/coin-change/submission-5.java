class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(coins.length==0 && amount >0){
            return -1;
        }
        int[] dp = new int[amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for(int coin : coins){
                if(coin <=i && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
                
            }
        }
        if(dp[amount] > amount+1){
            return -1;
        }else{
            return dp[amount];
        }
    }
}
