class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return dfs(prices,0,1,dp);
    }
    private int dfs(int[] prices,int index,int canBuy, Integer[][] dp){
        if(index>= prices.length){
            return 0;
        }
        if(dp[index][canBuy]!=null){
            return dp[index][canBuy];
        }
        int profit = 0;
        if(canBuy==1){
            int buy = -prices[index] + dfs(prices,index+1,0,dp);
            int skip = dfs(prices,index+1,1,dp);
            profit = Math.max(buy,skip);
        }else{
            int sell = prices[index] +dfs(prices,index+2,1,dp);
            int hold = dfs(prices,index+1,0,dp);
            profit = Math.max(hold,sell);
        }

        dp[index][canBuy] = profit;
        return profit;
    }
}
