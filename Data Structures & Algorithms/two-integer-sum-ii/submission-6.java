class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0;i<numbers.length-1;i++){
            int left = i+1;
            while(left<numbers.length){
                if(numbers[i]==numbers[left]){
                continue;
            }
            if(numbers[i]+numbers[left]==target){
                result[0] = i+1;
                result[1] = left+1;
                return result;
            }
            left++;
            }
            
        }
        return result;
    }
}
