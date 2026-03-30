class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length * matrix[0].length)-1;
        while(left<=right){
            int mid = left + (right -left)/2;
            int rowMid = mid/matrix[0].length;
            int colMid =  mid % matrix[0].length;
            if(matrix[rowMid][colMid] == target){
                return true;
            }else if(matrix[rowMid][colMid] > target){
                right = mid-1;;
            }else{
                left = mid +1;
            }
        }
        return false;
    }
}
