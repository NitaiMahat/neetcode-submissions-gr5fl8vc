class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointer1 = 0;
        int pointer2 = numbers.length-1;
        while(pointer1<pointer2){
            int sum = numbers[pointer1] + numbers[pointer2];
            if( sum == target){
                return new int[]{pointer1+1,pointer2+1};
            }else if(sum>target){
                pointer2--;
            }else{
                pointer1++;
            }
        }
        return new int[]{};
    }
}
