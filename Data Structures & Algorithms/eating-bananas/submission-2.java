class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int minSpeed = 1;
         int maxSpeed = 0;
        for(int pile: piles){
            maxSpeed = Math.max(maxSpeed,pile);
        }
       
        while(minSpeed<maxSpeed){
            int mid = minSpeed+ (maxSpeed-minSpeed)/2;

            if(canEatInTime(mid,h,piles)){
                maxSpeed = mid;
            }else{
                minSpeed = mid+1;
            }
        }
        return maxSpeed;
    }
    private boolean canEatInTime(int mid,int h,int[] piles){
        int hours = 0;
        for(int pile : piles){
            hours +=  (int) Math.ceil((double) pile/mid);
        }
        return hours <=h;
    }
}
