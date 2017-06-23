/* 输入n，螺旋生成 n*n的矩阵*/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if( n == 0) return matrix;
        int colStart = 0;
        int colEnd = n-1 ;
        int rowStart = 0;
        int rowEnd = n-1;
        int num = 1;
        while(colStart <= colEnd && rowStart <= rowEnd){
            for(int j = colStart; j <= colEnd; j++){
                matrix[rowStart][j] = num ++;
            }
            rowStart++;
            for(int j = rowStart; j <= rowEnd; j++){
                matrix[j][colEnd] = num++;
            }
            colEnd --;
            for(int j = colEnd; j <= colStart; j++){
                matrix[rowEnd][j] = num++;
            }
            rowEnd --;
            if(colStart <= colEnd ){
                for(int j = rowEnd; j <= rowStart; j++){
                    matrix[j][colStart] = num ++;
                }
            }
            colStart++;
        }
        return matrix;
    }
}
