class Solution {
    public int minOperations(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        for(int i=0;i<s.length();i++){
           char expectedZero;
           if(i%2==0){
            expectedZero = '0';
           }else{
            expectedZero = '1';
           }
           if(s.charAt(i)!=expectedZero){
            zeroCount++;
           }
           char expectedOne;
           if(i%2==0){
            expectedOne = '1';
           }else{
            expectedOne = '0';
           }
           if(s.charAt(i)!= expectedOne){
            oneCount++;
           }
        }
        return Math.min(zeroCount,oneCount);
     
    }
}