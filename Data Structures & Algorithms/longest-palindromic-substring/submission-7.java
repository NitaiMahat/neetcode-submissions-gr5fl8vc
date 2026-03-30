class Solution {
    public String longestPalindrome(String s) {
        int longest =0;
        int leftIndex = 0;
        for(int i=0;i<s.length();i++){
            int j = i;
            while(j<s.length()){
                if(isPalindrome(s.substring(i,j+1))){
                    if(j-i +1 > longest){
                        longest = j-i+1;
                        leftIndex = i;
                    }
                }
                j++;
            }
        }
        return s.substring(leftIndex, leftIndex + longest);
    }
    private boolean isPalindrome(String word){
        int left = 0;
        int right = word.length()-1;
        while(left <=right){
            if(word.charAt(left)!=word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
