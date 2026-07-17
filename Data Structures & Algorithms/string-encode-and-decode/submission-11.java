class Solution {

    public String encode(List<String> strs) {
        String newString = "";
        for(String word: strs){
             newString += word.length() + "#" + word;
        
        }
        return newString;
       
        
    }

    public List<String> decode(String str) {
        List<String> finalList = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            String currWord = str.substring(i,i+length);
            finalList.add(currWord);
            i+=length;
        }
        return finalList;

    }
}
