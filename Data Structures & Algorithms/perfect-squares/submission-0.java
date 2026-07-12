class Solution {
    public int numSquares(int n) {
      
       /**
            n =8 5
            n = 7  4
             n = 6 3
             n = 5 2
             n = 4 1
             n = 3 3
             n = 2 2
             n = 1 1
             n = 0 1

       **/
       int[] dp = new int[n+1];
       dp[0] = 0;
       
       for(int i=1;i<dp.length;i++){
        dp[i] = Integer.MAX_VALUE;
        for(int j=1;j*j <=i;j++){
            dp[i] = Math.min(dp[i],dp[i-j*j]+1);

        }
       }
       return dp[n];

    
    }
}