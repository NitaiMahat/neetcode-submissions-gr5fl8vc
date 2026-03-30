class Solution {
    public List<String> generateParenthesis(int n) {
        String currentString = "";
        List<String> currentList = new ArrayList<>();
        backTrack(currentList,currentString,0,0,n);
        return currentList;
    }
    private void backTrack(List<String> currentList, String currentString, int open,int close,int max){
        if(currentString.length() == (max*2)){
            currentList.add(currentString);
            return;
        }
        if(open < max){
            backTrack(currentList,currentString + "(",open+1,close,max);
        }
        if(close <open){
             backTrack(currentList,currentString + ")",open,close+1,max);
        }
    }
}
