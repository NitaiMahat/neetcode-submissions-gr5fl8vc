class Solution {
    public int climbStairs(int n) {
        int[] dpList = new int[n+1];
        dpList[0] = 1;
        dpList[1] = 1;
        for(int i=2;i<=n;i++){
            dpList[i] = dpList[i-1] + dpList[i-2];
        }

        return dpList[n];
    }

}
