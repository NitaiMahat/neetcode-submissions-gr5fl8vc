class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> finalList = new ArrayList<>();
        for(int num:stones){
            finalList.add(num);
        }

       while(finalList.size()>1){
        Collections.sort(finalList);
        int y = finalList.get(finalList.size()-1);
        int x = finalList.get(finalList.size()-2);
        if(x==y){
            finalList.remove(finalList.size()-1);
            finalList.remove(finalList.size()-1);
        }else{
            int newStone = y-x;
            finalList.remove(finalList.size()-1);
            finalList.remove(finalList.size()-1);
            finalList.add(newStone);
        }
       }
       if(finalList.size()==0){
        return 0;
       }
       return finalList.get(0);
       

    }
}
