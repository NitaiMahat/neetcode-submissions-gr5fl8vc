class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterToDigit = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String temp = "";
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> finalList = new ArrayList<>();
        dfs(digits,letterToDigit,temp,finalList,0);
        return finalList;
    }
    private void dfs(String digits,String[] letterToDigit,String temp,List<String> finalList,int index){
        if(temp.length()==digits.length()){
            finalList.add(temp);
            return;
        }
        String currDigit = letterToDigit[digits.charAt(index)-'0'];
        for(char c:currDigit.toCharArray()){
            dfs(digits,letterToDigit,temp+c,finalList,index+1);
        }
    }
}
