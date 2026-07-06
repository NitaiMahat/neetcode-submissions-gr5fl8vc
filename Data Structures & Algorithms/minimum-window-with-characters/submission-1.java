class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
       
   
        int[] freq = new int[128];
        for(char let : t.toCharArray()){
            freq[let]++;
        }
        int counter = 0;
        int smallest = s.length()+1;
        String ans = "";

        int left = 0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)]--;
            if(freq[s.charAt(right)]>=0){
                counter++;
            }
            while(counter == t.length()){
                int currWindow = right - left+1;
                if(currWindow < smallest){
                    smallest = currWindow;
                    ans = s.substring(left,right+1);
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0){
                    counter--;
                }
                left++;
            }

        }
        return ans;
        
    }
}
