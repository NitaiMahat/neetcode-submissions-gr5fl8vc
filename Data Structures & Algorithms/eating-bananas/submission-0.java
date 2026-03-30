class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length-1];
        while(start<=end){
            long totalTime = 0;
            int k = (start+end)/2;
            if(eatingTime(k,h,piles)){
                end = k-1;
            }else{
                start = k+1;
            }
            
        }
        return start;
    }

    private boolean eatingTime(int k,int h, int[] piles){
        int hour = 0;
        for(int p:piles){
            hour += Math.ceil((double) p/k);
        }
        return hour<=h;
    }
}
