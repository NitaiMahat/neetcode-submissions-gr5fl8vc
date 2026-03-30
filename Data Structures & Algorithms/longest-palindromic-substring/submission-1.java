class Solution {
    public String longestPalindrome(String s) {
        int longLength = 0;
        int index = 0;
        for(int i=0;i<s.length();i++){
            int left  = i;
            int right = i;
            while(left>=0 && right < s.length() && s.charAt(left)== s.charAt(right)){
                if(right-left+1> longLength){
                    longLength = right - left +1;
                    index = left;
                }
                left--;
                right++;
            }

            int l = i;
            int r = i+1;
            while(l>=0 && r < s.length() && s.charAt(l)== s.charAt(r)){
                if(r-l+1> longLength){
                    longLength = r - l +1;
                    index = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(index,index+longLength);
    }
}
