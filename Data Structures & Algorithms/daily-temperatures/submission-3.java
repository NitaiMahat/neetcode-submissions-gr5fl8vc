class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] finalArr = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevIndex = stack.pop();
                finalArr[prevIndex] = i - prevIndex ;
            }
            stack.push(i);
        }
        return finalArr;
    }
}
