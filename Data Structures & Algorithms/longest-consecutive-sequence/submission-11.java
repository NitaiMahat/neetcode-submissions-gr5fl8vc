class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> seenSet = new HashSet<>();
        for(int num : nums){
            seenSet.add(num);

        }
        for(int num : seenSet){
            if(!seenSet.contains(num-1)){
                int current = num;
                int length = 0;
               while(seenSet.contains(current)){
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
