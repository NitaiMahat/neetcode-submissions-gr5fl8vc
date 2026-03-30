class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        for(int n: set){
            int temp = 0;
            int current = n;
            while(set.contains(current)){
                temp++;
                current++;
            }
            longest = Math.max(longest,temp);
        }
        return longest;
        
    }
}
