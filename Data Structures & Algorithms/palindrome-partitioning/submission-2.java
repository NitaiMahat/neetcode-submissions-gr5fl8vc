class Solution {
    List<List<String>> finalList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        return finalList;
    }
    private void backtrack(String s,int index, List<String> current){
        if(s.length()==index){
            finalList.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index, i +1))){
                current.add(s.substring(index,i+1));
                backtrack(s,i+1,current);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean isPalindrome(String word){
        int left = 0;
        int right = word.length()-1;
        while(left<=right){
            if(word.charAt(left)!= word.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
