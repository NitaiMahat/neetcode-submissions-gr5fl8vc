class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String words:strs){
            result += words.length() + "#" + words;
        }
        return result;
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }
        List<String> finalList = new ArrayList<>();
        int count =0;
        while(count< str.length()){
            int right = count;
            while(str.charAt(right) != '#'){
                right++;
            }
            int length = Integer.parseInt(str.substring(count,right));
            String finalWord = str.substring(right+1, right +1+length);
            finalList.add(finalWord);
            count = right +1+length;

        }
        return finalList;
    }
}
