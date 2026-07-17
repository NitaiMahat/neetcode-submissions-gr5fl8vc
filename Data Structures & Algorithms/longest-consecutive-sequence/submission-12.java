class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest = 0;
        for(int num:nums){
            int tempLength = 0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    tempLength++;
                    num++;
                }
                longest = Math.max(longest,tempLength);
            }

        }
        return longest;
    
    }
}
