class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
    
        for(String email: emails){
                boolean ignore = false;
        boolean domain = false;
            StringBuilder ans = new StringBuilder();
            for(char c : email.toCharArray()){
                if(c=='@'){
                    ignore =false;
                    domain = true;
                     ans.append(c);
                }else if(domain){
                    ans.append(c);
                }else if(c=='+'){
                    ignore = true;
                }else if(ignore){
                    continue;
                }else if(c=='.'){
                    continue;
                }else{
                    ans.append(c);
                }
            }
            set.add(ans.toString());
        }
        return set.size();
    }
}