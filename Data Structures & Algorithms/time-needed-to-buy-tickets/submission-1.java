class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target = tickets[k];
        int time = 0;
        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                time += Math.min(target,tickets[i]);
            }else{
                time += Math.min(target-1,tickets[i]);
            }
        }
        return time;
    }
}