class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("*");
        set.add("+");
        set.add("-");
        set.add("/");
        Stack<Integer> stack = new Stack<>();
        for(String word : tokens){
            if(!set.contains(word)){
                stack.push(Integer.valueOf(word));
            }else{
                int value2 = stack.pop();
                int value1 = stack.pop();
                String symbol = word;
                stack.push(calc(value1,value2,symbol));
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
