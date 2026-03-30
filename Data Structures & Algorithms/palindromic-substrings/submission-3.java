class Solution {
    public int countSubstrings(String s) {
        int numSubstring = 0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
                numSubstring++;
                left--;
                right++;
            }
            int l = i;
            int r = i+1;
              while(l >=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                numSubstring++;
                l--;
                r++;
            }
            
        }
        return numSubstring;
    }
}
