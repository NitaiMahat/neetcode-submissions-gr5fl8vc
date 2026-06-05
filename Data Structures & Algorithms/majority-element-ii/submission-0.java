class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0;
        int cand2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(count1 >0 && cand1==num){
                count1++;
            }else if(count2 >0 && cand2 == num){
                count2++;
            }else if(count1==0){
                count1++;
                cand1 = num;
            }else if(count2==0){
                count2++;
                cand2 = num;
            }else{
                count1--;
                count2--;
            }
        }
        //pass 2
        count1=0;
        count2=0;
        for(int num: nums){
            if(cand1==num){
                count1++;
            }else if(cand2==num){
                count2++;
            }
        }
        List<Integer> finalList = new ArrayList<>();
        int threshold = nums.length/3;
        if(count1>threshold){
            finalList.add(cand1);
        }
        if(count2> threshold){
            finalList.add(cand2);
        }
        return finalList;
    }
}