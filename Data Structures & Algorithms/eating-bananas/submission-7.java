class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = piles[0];
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed,pile);
        }
        while(minSpeed<maxSpeed){
            int midSpeed = minSpeed +(maxSpeed-minSpeed)/2;
            if(canEat(piles,midSpeed,h)){
                maxSpeed = midSpeed;
            }else{
                minSpeed = midSpeed+1;
            }
        }
        return minSpeed;
    }
    private boolean canEat(int[] piles,int speed,int h){
        int timeTake = 0;
        for(int pile:piles){
            timeTake += (pile+speed-1)/speed;

            if(timeTake >h){
                return false;
            }
        }
        return true;
    }
}
