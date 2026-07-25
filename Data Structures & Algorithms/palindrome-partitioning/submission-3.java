class Solution {
    private List<List<String>> finalList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.isEmpty()){
            return finalList;
        }
        List<String> current = new ArrayList<>();
        dfs(s,current,0);
        return finalList;
    }
    private void dfs(String s, List<String> current,int index){
        if(index==s.length()){
            finalList.add(new ArrayList<>(current));
            return;
        }
        for(int end = index;end<s.length();end++){
            if(isPalindrome(s.substring(index,end+1))){
                current.add(s.substring(index,end+1));
                dfs(s,current,end+1);
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
