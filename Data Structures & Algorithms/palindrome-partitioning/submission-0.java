class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result,s,new ArrayList<>(),0);
        return result;
    }
    private void dfs(List<List<String>> result, String s, List<String> temp, int index){
        if(s.length()==index){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                dfs(result,s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
