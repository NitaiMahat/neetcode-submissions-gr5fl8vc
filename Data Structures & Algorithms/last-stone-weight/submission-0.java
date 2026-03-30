class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int num : stones){
            list.add(num);
        }
        while(list.size() >1){
            Collections.sort(list);
            int y = list.get(list.size()-1);
            int x = list.get(list.size()-2);
            if(x==y){
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            }else{
                  y = y-x;
                  list.remove(list.size()-1);
                  list.remove(list.size()-1);
                  list.add(y);
            }
            
          
            

        }
        if(list.size()==0){
                return 0;
            }
            return list.get(0);
        
    }
}
