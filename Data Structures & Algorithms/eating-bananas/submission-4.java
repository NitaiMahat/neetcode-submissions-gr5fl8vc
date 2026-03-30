class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed,pile);
        }
        while(minSpeed <=maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;
            if(canEatInTimes(mid,h,piles)){
                maxSpeed = mid-1;
            }else{
                minSpeed = mid+1;
            }
        }
        return minSpeed;
    }
    private boolean canEatInTimes(int mid,int h,int[] piles){
        int hour = 0;
        for(int pile : piles){
            hour += (int) Math.ceil((double) pile/mid);
        }
        return hour <=h;
    }
}
