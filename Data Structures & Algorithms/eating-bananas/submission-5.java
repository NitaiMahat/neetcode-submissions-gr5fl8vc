class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /**
            first thought := greedy  taking max value and then using taht 
            how ever we need minmum integer so by logic it will be 1 - > max value

        
         */
         int minSpeed = 1;
         int maxSpeed = 0;
         for(int pile : piles){
            maxSpeed = Math.max(maxSpeed,pile);

         }

         while(minSpeed <= maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;
            if(canEatInTime(piles,mid,h)){
                maxSpeed = mid-1;
            }else{
                minSpeed = mid+1;
            }
         }
         return minSpeed;
    }
    private boolean canEatInTime(int[] piles, int mid, int h){
        int hour = 0;
        for(int pile:piles){
            hour += (int) Math.ceil((double) pile/mid);
        }
        return hour <=h;
    }
}