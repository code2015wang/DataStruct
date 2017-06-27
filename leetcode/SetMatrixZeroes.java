/*给定一个m*n的矩阵，如果一个元素为0,则将其整行整列设置为0*/
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix){
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr){
            for(int j = 0; j <matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        if(fc){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
