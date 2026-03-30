class Solution {
    public int reverseBits(int n) {
        int count =0;
        for(int i=0;i<32;i++){
            count <<=1;

            if((n&1)==1){
                count++;
            }
            n>>=1;


        }
        return count;
    }
}
