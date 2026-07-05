class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> seenSymbol = new HashSet<>();
        seenSymbol.add("+");
        seenSymbol.add("-");
        seenSymbol.add("/");
        seenSymbol.add("*");
        Stack<Integer> stack = new Stack<>();
        for(String character : tokens){
            if(!seenSymbol.contains(character)){
                stack.push(Integer.parseInt(character));
            }else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                String symbol = character;
                stack.push(calc(num1,num2,symbol));
            }
        }
        return stack.peek();
    }
    private int calc(int num1 , int num2,String symbol){
        if(symbol.equals("+")){
            return num1 + num2;
        }else if(symbol.equals("-")){
            return num1 - num2;
        }else if(symbol.equals("*")){
            return num1 * num2;
        }else{
            return (int) num1 / (int) num2;
        }
    }
}
