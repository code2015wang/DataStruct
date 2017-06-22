/* 螺旋输出一个n*n的矩阵，如矩阵
   [
   [1,2,3],
   [4,5,6],
   [7,8,9]
]
输出 [1,2,3,6,9,8,7,4,5]
*/
import java.util.List;
import java.util.ArrayList;
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) retrun res;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin  = 0;
        int colEnd = matrix[0].length - 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int j = colBegin; j<= colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for(int j = rowBegin; j <= rowEnd; j ++ ){
                res.add(matrix[j][colEnd]);
            }
            colEnd --;
            for(int j = colEnd ; j >= 0 ; j--){
                res.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if(colBegin <= colEnd){
                for(int j = rowEnd; j >= rowBegin; j--){
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
