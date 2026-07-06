class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
    
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=heights.length;i++){
            int currHeight;
            if(heights.length==i){
                currHeight = 0;
            }else{
                currHeight = heights[i];
            }
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int top = stack.pop();
                int width;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i-stack.peek()-1;
                }
                maxArea = Math.max(maxArea,width*heights[top]);

            }
            stack.push(i);
           

        }
        return maxArea;
    }
}
