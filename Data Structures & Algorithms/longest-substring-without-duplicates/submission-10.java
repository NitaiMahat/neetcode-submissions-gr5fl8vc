class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> storage = new HashSet<>();
        int longest = 0;
        int left = 0;

        for(int right = 0; right < s.length();right++){
            while(storage.contains(s.charAt(right))){
                storage.remove(s.charAt(left));
                left++;
            }
            storage.add(s.charAt(right));
            longest = Math.max(longest,right-left+1);
        }
        return longest;
    }
}
