class Solution {
    int[] left;
    int[] right;
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1){
            return heights[0];
        }
        left = new int[heights.length];
        right = new int[heights.length];
        findLeft(heights);
        findRight(heights);
        int large = 0;
        for(int i=0;i<heights.length;i++){
            large = Math.max(large, (right[i] -left[i]-1) * heights[i]);
        }
        return large;
    }
    private void findLeft(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int left1 = 0;
        while(left1<heights.length){
             while(!stack.isEmpty() && heights[stack.peek()] >= heights[left1] ){
                stack.pop();
             }
             if(stack.isEmpty()){
                left[left1] = -1;
             }else{
                left[left1] = stack.peek();
             }
             stack.push(left1);
             left1++;
        }
       
    }
     private void findRight(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int right1= heights.length-1;
        while(right1>=0){
             while(!stack.isEmpty() && heights[stack.peek()] >= heights[right1] ){
                stack.pop();
             }
             if(stack.isEmpty()){
                right[right1] = heights.length;
             }else{
                right[right1] = stack.peek();
             }
             stack.push(right1);
             right1--;
        }
       
    }
}
