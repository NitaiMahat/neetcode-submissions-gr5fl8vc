class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] finalList = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    int prevIndex = stack.pop();
                    finalList[prevIndex] = i-prevIndex;
                }
                    stack.push(i);
                
            }
        }
        return finalList;
    }
}
