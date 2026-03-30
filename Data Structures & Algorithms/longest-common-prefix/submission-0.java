class Solution {
    public String longestCommonPrefix(String[] strs) {
        /**
        my intial though would be sorting the array so it makes closly realted string be toegtehr 
        by that logic i can comapre the first string ith the last string each cahracter and
        find the common letter and append it to a string variable.

        O(n log n * m )

        there is another approhc
        where i shrink the prefix until it starswitha  prefix for emxaple
        ill have the first index as prefix loop though the array and check if the current index elemt starts with the prefix
        if not i will reduce prefix 
        if yes i will reutrn
        **/

    

    if (strs == null || strs.length==0){
        return "";
    }
    String prefix = strs[0];
    for(int i=1;i<strs.length;i++){
        while(!strs[i].startsWith(prefix)){
            prefix = prefix.substring(0,prefix.length()-1);
            if(prefix.isEmpty()){
                return "";
            }
        }
        
    }
    return prefix;
}
}