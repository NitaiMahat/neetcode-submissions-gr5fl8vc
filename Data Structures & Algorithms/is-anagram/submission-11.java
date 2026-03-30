class Solution {
    public boolean isAnagram(String s, String t) {
        //brute force:
        /**
            char[] ;
            sort cahr[](n log n) n = lenth of the string
            check if one char == char;


            another appraoach:
            since lower case :
            ffixed arary size 26;
            and then store it and at the same time minus the otherr strings cahracter
        */
        if(s.length()!=t.length()){
            return false;
        }
        int[] seenArray = new int[26];
       
        for(int i=0;i<s.length();i++){
            seenArray[s.charAt(i)-'a']++;
            seenArray[t.charAt(i)-'a']--;
        }
        int count = 0;
        for(int i=0;i<seenArray.length;i++){
            if(seenArray[i]!=0){
                return false;
            }
        }
        return true;

    }
}
