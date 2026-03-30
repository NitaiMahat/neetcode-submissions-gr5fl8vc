class Solution {
    public int[] countBits(int n) {
        int[]  finalList = new int[n+1];
        for(int i=0;i<finalList.length;i++){
            finalList[i] =Integer.bitCount(i);
        }
        return finalList;
    }
}
