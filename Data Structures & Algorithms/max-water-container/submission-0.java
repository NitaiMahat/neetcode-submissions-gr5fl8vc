class Solution {
    public int maxArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }

        int left = 0;
        int right = heights.length-1;
        int max = Integer.MIN_VALUE;
        while(left<right){
            int width = right - left;
            if(heights[left]< heights[right]){
                max = Math.max(max,heights[left] * width);
                left++;
            }else if(heights[right]< heights[left]){
                max = Math.max(max,heights[right]*width);
                right--;
            }else{
                max = Math.max(max,heights[right]*width);
                left++;
                right--;
            }
        }
        return max;
    }
}
