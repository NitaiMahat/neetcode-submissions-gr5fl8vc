class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digitToLetter ={
            "", "", "abc", "def","ghi", "jkl", "mno", "pqrs","tuv", "wxyz"
        };
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        dfs(digitToLetter,result,0,digits,"");
        return result;

    }

    private void dfs(String[] digitToLetter,List<String> result, int index,String digits, String currString){
        if(currString.length()==digits.length()){
            result.add(currString);
            return;
        }

        String chars = digitToLetter[digits.charAt(index) - '0'];
        for(char c: chars.toCharArray()){
            dfs(digitToLetter,result,index+1,digits,currString+c);
        }
    }
}
