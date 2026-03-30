class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String word : strs){
            int length = word.length();
            result+= length + "#" + word;
        }
        return result;

    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int i=0;
        while(i <str.length()){
            int j = i;
            while(str.charAt(j)!= '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            result.add(str.substring(i,i+length));
            i += length;
        }
        return result;
    }
}
