class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length() || s2.length()==0){
            return false;
        }
        if(s1.length()==0){
            return true;
        }

        int[] seen1 = new int[26];
        int[] seen2 = new int[26];
        for(int i=0;i<s1.length();i++){
            seen1[s1.charAt(i)-'a']++;
            seen2[s2.charAt(i)-'a']++;
        }
        for(int i=s1.length();i<s2.length();i++){
            if(Arrays.equals(seen1,seen2)){
                return true;
            }
            seen2[s2.charAt(i-s1.length())-'a']--;
            seen2[s2.charAt(i)-'a']++;

        }
        return Arrays.equals(seen1,seen2);
    }
}
