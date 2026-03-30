class Solution {
    public int maxProfit(int[] prices) {
        int finalProfit = 0;
        for(int left=0;left<prices.length;left++){
            int right = left+1;
            while(right<prices.length){
                int tempProft = prices[right]-prices[left];
                finalProfit = Math.max(tempProft,finalProfit);
                right++;
            }
        }
        return finalProfit;
    }
}
