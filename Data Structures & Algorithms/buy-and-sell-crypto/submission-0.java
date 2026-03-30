class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            int temp = 0;
            int right = prices.length-1;
            while(i<right){
                
               
                temp = prices[right]-prices[i];
                maxProfit = Math.max(maxProfit,temp);
            
            right--;
            
            }
            
            
            
        }
        return maxProfit;
    }
}
