class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterToDigit = {
            "","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        backTrack(result,letterToDigit,digits,"",0);
        return result;

}
    private void backTrack(List<String> result,String[] letterToDigit, String digits,String currentWord,int index){
        if(digits.length()==currentWord.length()){
            result.add(currentWord);
            return;
        }
        String currentLetter = letterToDigit[digits.charAt(index)-'0'];
        for(char c : currentLetter.toCharArray()){
            backTrack( result, letterToDigit,  digits, currentWord+c, index+1);
        }
    }
}
