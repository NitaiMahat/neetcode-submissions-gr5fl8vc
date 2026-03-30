class Solution {
    List<String> finalList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
       backtrack("",0,0,n);
       return finalList;
    }
    private void backtrack(String current,int open,int close, int n){
        if(current.length()==n*2){
            finalList.add(current);
            return;
        }
        if(open <n){
            backtrack(current + "(",open+1,close,n);
        }
        if(close< open){
             backtrack(current + ")",open,close+1,n);
        }

    }
}
