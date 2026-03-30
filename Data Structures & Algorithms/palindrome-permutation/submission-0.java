class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] seen = new int[128];
        int count = 0;
        for(int i=0;i<s.length();i++){
            seen[s.charAt(i)]++;
            if(seen[s.charAt(i)]%2==0){
                count--;
            }else{
                count++;
            }
        }
        
        return count <=1;
    }
}
