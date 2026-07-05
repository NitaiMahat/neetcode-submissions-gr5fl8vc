class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> bracketMap = new HashMap<>();
        bracketMap.put('}','{');
        bracketMap.put(')','(');
        bracketMap.put(']','[');
        Stack<Character> symbolStack = new Stack<>();
        for(char bra : s.toCharArray()){
            if(!bracketMap.containsKey(bra)){
                symbolStack.push(bra);
            }else{
                if(!symbolStack.isEmpty()){
                    char br = symbolStack.pop();
                    if(bracketMap.get(bra)!=br){
                        return false;
                    }else{
                       
                    }
                }else{
                    return false;
                }
            }

        }
        return symbolStack.isEmpty();

    }
}
