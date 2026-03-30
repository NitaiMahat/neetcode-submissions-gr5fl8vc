class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length() || s2.length()==0){
            return false;
        }
        if(s1.length()==0){
            return true;
        }
        int s1Length = s1.length();
        int s2Length = s2.length();
        int[] s1Seen = new int[26];
        int[] s2Seen = new int[26];
        for(int i=0;i<s1Length;i++){
            s1Seen[s1.charAt(i)-'a']++;
            s2Seen[s2.charAt(i)-'a']++;
        }
        for(int i=s1Length;i<s2Length;i++){
            if(Arrays.equals(s1Seen,s2Seen)){
                return true;
            }
            s2Seen[s2.charAt(i-s1Length)-'a']--;
            s2Seen[s2.charAt(i)-'a']++;

        }

        return Arrays.equals(s1Seen,s2Seen);

    }
}
