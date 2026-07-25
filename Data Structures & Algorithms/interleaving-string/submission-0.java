class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!= s3.length()){
            return false;
        }
        Map<String,Boolean> cache = new HashMap<>();
        return dfs(s1,s2,s3,0,0,cache);
    }
    private boolean dfs(String s1,String s2,String s3,int index1,int index2,Map<String,Boolean> cache){
        if(s1.length()==index1 && s2.length()==index2){
            return true;
        }
        String key = index1 + "," + index2;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int s3Index = index1+index2;
        boolean result = false;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(s3Index)){
            result = dfs(s1,s2,s3,index1+1,index2,cache);
        }
        if(!result && index2 < s2.length() && s2.charAt(index2)==s3.charAt(s3Index)){
            result = dfs(s1,s2,s3,index1,index2+1,cache);
        }
        cache.put(key,result);
        return result;
    }
}
