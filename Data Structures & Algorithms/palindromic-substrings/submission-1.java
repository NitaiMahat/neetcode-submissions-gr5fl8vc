class Solution {
    public int countSubstrings(String s) {
        int result  =0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }

            int l = i;
            int ri = i+1;
            while(l>=0 && ri < s.length() && s.charAt(l)==s.charAt(ri)){
                result++;
                l--;
                ri++;
            }
        }
        return result;
    }
}
