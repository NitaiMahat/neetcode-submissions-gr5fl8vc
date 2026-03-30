class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs){
            int length = str.length();
            result += length + "#" +str;
        }
        return result;
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }
        List<String> finalList = new ArrayList<>();
        int i=0;
        String result = "";
        while(i< str.length()){
            int j = i;
            while(str.charAt(j)!= '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            result = str.substring(i,length+i);
            finalList.add(result);
            i += length;

        }
        return finalList;
    }
}
