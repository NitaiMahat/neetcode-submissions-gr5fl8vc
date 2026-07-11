class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        Character prevOperator = '+';
        Set<Character> seenSet = new HashSet<>();
        seenSet.add('+');
        seenSet.add('*');
        seenSet.add('/');
        seenSet.add('-');
        int left = 0;
        int right = 0;
        while(right<=s.length()){
            while(right<s.length() && !seenSet.contains(s.charAt(right))){
                right++;
            }
            int number = Integer.valueOf(s.substring(left,right).trim());
            stack.push(calc(number,prevOperator,stack));
             if (right < s.length()) {
                prevOperator = s.charAt(right);
            }
            left = right+1;
            right++;
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
    private int calc(int number , Character operator, Stack<Integer> stack){
        if(operator=='+'){
            return number;
        }else if(operator=='-'){
            return -number;
        }else if(operator=='*'){
            return number * stack.pop();
        }else if(operator=='/'){
            return stack.pop()/number;
        }
        return -1;
    }
}