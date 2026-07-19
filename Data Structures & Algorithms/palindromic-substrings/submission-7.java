class Solution {
    public int countSubstrings(String s) {
        if(s.length() ==0){
            return 0;
        }
        int count = 1;
        for(int i=1;i<s.length();i++){
            int high = i;
            int low = i;
            while(s.charAt(low)==s.charAt(high)){
                high++;
                low--;
                count++;
                if(low<=-1 || high >= s.length()){
                    break;
                }
            }
           

            low = i-1;
            high = i;

            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                count++;
                if(low<=-1 || high >= s.length()){
                    break;
                }
            }
           
        }
        return count;

    
    }
}
