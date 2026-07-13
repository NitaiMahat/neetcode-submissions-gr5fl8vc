class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> finalList = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBeign = 0;
        int colEnd = matrix[0].length-1;
          if (matrix.length == 0) {
      return finalList;
    }
        while(rowBegin <= rowEnd && colBeign <= colEnd){
            //go right
            for(int i=colBeign;i<=colEnd;i++){
                finalList.add(matrix[rowBegin][i]);

            }
            rowBegin++;
            //go down
            for(int i=rowBegin ;i <=rowEnd;i++){
                finalList.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd){
                //go left;
                for(int i = colEnd; i >=colBeign;i--){
                    finalList.add(matrix[rowEnd][i]);
                }
                
            }
            rowEnd--;

            if(colBeign <= colEnd){
                //go up
                for(int i=rowEnd;i>= rowBegin;i--){
                    finalList.add(matrix[i][colBeign]);
                }
            }
            colBeign++;
            
        }
        return finalList;
    }
}
