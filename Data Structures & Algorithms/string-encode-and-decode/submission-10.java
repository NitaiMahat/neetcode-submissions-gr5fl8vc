class Solution {

    public String encode(List<String> strs) {
        StringBuilder newString = new StringBuilder();
        for(String word : strs){
            int length = word.length();
            newString.append(length + "#" + word);
        }
        return newString.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }
       
        List<String> finalList = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
           i = j+1;
           String currWord =str.substring(i,i+length);
           finalList.add(currWord);
           i+= length;


        }
        return finalList;
    }
}
