class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length)-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int rowMid = mid/matrix[0].length;
            int colMid = mid%matrix[0].length;
            if(matrix[rowMid][colMid]==target){
                return true;
            }else if(matrix[rowMid][colMid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
