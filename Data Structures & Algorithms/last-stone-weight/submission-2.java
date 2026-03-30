class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> finalList = new ArrayList<>();
        for(int stone: stones){
            finalList.add(stone);
        }
       

     while(finalList.size() > 1){
         Collections.sort(finalList);
         int y = finalList.get(finalList.size()-1);
            int x = finalList.get(finalList.size()-2);
            if(y==x){
                finalList.remove(finalList.size()-1);
                finalList.remove(finalList.size()-1);
            }else if(x<y){
                finalList.remove(finalList.size()-1);
                finalList.remove(finalList.size()-1);
                finalList.add(y-x);
                
            }

     }
     if(finalList.size() ==0){
        return 0;
     }
     return finalList.get(0);
           
        
    }
}
