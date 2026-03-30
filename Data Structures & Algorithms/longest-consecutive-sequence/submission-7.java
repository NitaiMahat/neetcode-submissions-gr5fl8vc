class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        Arrays.sort(nums);
        int longest = 0;
        for(int num : set){
            int temp = 0;
            int current = num;
            while(set.contains(current)){
                temp++;
                current++;
            }
            longest = Math.max(temp,longest);
        }
        return longest;


    }
}
