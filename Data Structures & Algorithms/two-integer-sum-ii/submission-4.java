class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] finalList = new int[2];
        
        for(int left=0;left<numbers.length;left++){
            int right = numbers.length-1;
            while(left<right){
                
                if(numbers[left] + numbers[right]==target){
                    finalList[0] = left+1;
                    finalList[1]= right+1;
                    return finalList;
                }
                right--;
            }
        }
        return finalList;
    }
}
