class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate = 0;
        int candidate2 = 0;
        int count = 0;
        int count2 = 0;
        for(int num:nums){
            if(count>0 && candidate ==num){
                count++;
            }else if(count2>0 && candidate2 == num){
                count2++;
            }else if(count==0){
                candidate = num;
                count++;
            }else if(count2==0){
                candidate2 = num;
                count2++;
            }else{
                count--;
                count2--;
            }
        }
        //phase2
        count = 0;
        count2 = 0;
        for(int num:nums){
            if(candidate==num){
                count++;
            }else if(candidate2==num){
                count2++;
            }
        }
        List<Integer> finalList = new ArrayList<>();
        int threshold = nums.length/3;
        if(count>threshold){
            finalList.add(candidate);
        }
        if(count2>threshold){
            finalList.add(candidate2);
        }
        return finalList;
    }
}