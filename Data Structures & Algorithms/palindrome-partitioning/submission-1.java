class Solution {
    List<List<String>> finalList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s,new ArrayList<>(),0);
        return finalList;
    }
    private void backTrack(String s , ArrayList<String> currentList,int index){
        if(s.length()==index){
            finalList.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(i,index,s)){
             currentList.add(s.substring(index,i+1));
            backTrack(s,currentList,i+1);
            currentList.remove(currentList.size()-1);
            }
            
        }
    }
    private boolean isPalindrome(int i,int j,String s){
        while(j<i){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
