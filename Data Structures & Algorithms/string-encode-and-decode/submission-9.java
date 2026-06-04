class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String str : strs){
            int length = str.length();
            encodedString +=length +"#" + str;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }
        List<String> finalList = new ArrayList<>();
        String result = "";
        int left = 0;
        while(left< str.length()){
            int j = left;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(left,j));
            left = j+1;
            result = str.substring(left,length+left);
            finalList.add(result);
            left += length;

        }
        return finalList;
    }
}
