class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        Stack<Character> stack  = new Stack<>();
        for(char pra : s.toCharArray()){
            if(map.containsKey(pra)){
                if(!stack.isEmpty() && stack.peek()==map.get(pra)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(pra);
            }
        }
        return stack.isEmpty();
    }
}
