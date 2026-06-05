class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seenSet = new HashSet<>();
        for(int num : nums){
            seenSet.add(num);
        }
        int longest = 0;
        for(int num : seenSet){
            if(!seenSet.contains(num-1)){
                int current = num;
                int length = 1;
                while(seenSet.contains(current+1)){
                    length++;
                    current++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
