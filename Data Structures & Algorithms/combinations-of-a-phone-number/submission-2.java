class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterToDigit = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        String temp = "";
        List<String> finalList = new ArrayList<>();
        if(digits.isEmpty()){
            return finalList;
        }
        backtrack(finalList,letterToDigit,temp,0,digits);
        return finalList;
    }
    private void backtrack(List<String> finalList, String[] letterToDigit,String current,int index,String digits){
          if(current.length()==digits.length()){
            finalList.add(current);
            return;
        }
        
            String currentLetter = letterToDigit[digits.charAt(index)-'0'];
            for(char c : currentLetter.toCharArray()){
                backtrack(finalList,letterToDigit,current + c,index+1,digits);
            }

        
    }
}
