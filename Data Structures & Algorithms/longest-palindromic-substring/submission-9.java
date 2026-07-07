class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        String ans = "";
        for(int i=1;i<s.length();i++){
            int low = i;
            int high = i;
            //odd length;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;

                if(low==-1 || high == s.length()){
                    break;
                }
            }
            String palindrome = s.substring(low+1,high);
            if(palindrome.length() > ans.length()){
                ans = palindrome;
            }

            low = i-1;
            high = i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high == s.length()){
                    break;
                }
            }
            palindrome = s.substring(low+1,high);
            if(palindrome.length() > ans.length()){
                ans = palindrome;
            }
        }
        return ans;


    }
}
