class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if("-*+/".contains(tokens[i])){
                int a = stack.pop();
                int b = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(b+a);
                }else if(tokens[i].equals("-")){
                    stack.push(b-a);
                }else if(tokens[i].equals("*")){
                    stack.push(b*a);
                }else{
                    stack.push(b/a);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
