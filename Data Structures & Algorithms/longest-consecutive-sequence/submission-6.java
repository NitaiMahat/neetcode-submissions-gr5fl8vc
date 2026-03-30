class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            int current = num;
            int length = 0;
            while(set.contains(current)){
                length++;
                current++;
            }
            longest = Math.max(longest,length);
        }
        return longest;
        
    }
}
