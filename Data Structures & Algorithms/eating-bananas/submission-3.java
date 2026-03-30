class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int pile:piles){
            maxSpeed = Math.max(pile,maxSpeed);
        }
        while(minSpeed<=maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;
            if(canEatInTime(piles,mid,h)){
                maxSpeed = mid-1;
            }else{
                minSpeed = mid+1;
            }
        }
        return minSpeed;

    }
    private boolean canEatInTime(int[] piles,int mid,int h){
        int hours = 0;
        for(int pile : piles){
            hours += (int) Math.ceil((double)pile/mid);
        }
        return hours <=h;
    }
    
}
