class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(char brac : s.toCharArray()){
            if(map.containsKey(brac)){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char br = stack.pop();
                    if(map.get(brac)!=br){
                        return false;
                    }
                }
            }else{
                stack.push(brac);
            }
        }
        return stack.isEmpty();
       
    }
}
