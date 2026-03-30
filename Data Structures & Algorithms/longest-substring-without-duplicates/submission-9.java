class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        Set<Character> seenSet = new HashSet<>();
        for(int right = 0;right<s.length();right++){
            while(seenSet.contains(s.charAt(right))){
                seenSet.remove(s.charAt(left));
                left++;
            }
            seenSet.add(s.charAt(right));
            longest = Math.max(longest,right-left +1);
        }
        return longest;
    }
}
