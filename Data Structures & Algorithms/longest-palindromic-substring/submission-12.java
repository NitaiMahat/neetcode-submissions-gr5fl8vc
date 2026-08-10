class Solution {
    public String longestPalindrome(String s) {
        /**
            need to figure out of odd and even

        **/
        int maxLen = 0;
        String ans = "";
        for(int i=0;i<s.length();i++){
            int low = i;
            int high = i;
            while(low >=0 && high <= s.length()-1 && s.charAt(low)==s.charAt(high)){
                
                low--;
                high++;
            }
            if(high-low+1 > maxLen){
                    ans = s.substring(low+1,high);
                    maxLen = high-low+1;

                }

            low = i;
            high = i+1;
            while(low >=0 && high <= s.length()-1 && s.charAt(low)==s.charAt(high)){
                
                low--;
                high++;
            }
            if(high-low+1 > maxLen){
                    ans = s.substring(low+1,high);
                    maxLen = high-low+1;

                }

        }
        return ans;
    }
}
