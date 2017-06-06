/* 给定一个整数n，生成一个n×n的矩阵，矩阵用元素1到n^2螺旋填充。如给定一个整数3,输出的矩阵如下：
   [
   [1,2,3],
   [8,9,4],
   [7,6,5]
]
*/
public class spiralMatrixII {
    public static int[][] generateMatrix(int n){
        int[][] spiral = new int[n][n];
        if(n == 0) return spiral;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int number = 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart;i<= colEnd; i++){
                spiral[rowStart][i] = number++;
            }
            rowStart ++;
            for(int i = rowStart ; i <= rowEnd; i++){
                spiral[i][colEnd] = number++;

            }
            colEnd--;
            for(int i = colEnd; i >= colStart; i--){
                spiral[rowEnd][i] = number++;
            }
            rowEnd--;
            for(int i = rowEnd; i >=rowStart; i--){
                /*注意这里要先判断colStart和colEnd的关系，当n=2时，到这一步的时候，colStart==colEnd.因此要先判断才能决定是否继续*/
                if(colStart <= colEnd){
                    spiral[i][colStart] = number++;
                }
            }
            colStart ++;
        }
        return spiral;
    }
    public static void main(String[] args){
        int n = 3;
        int[][] spiral =  generateMatrix(n);
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n ;j++){
                System.out.print(spiral[i][j]+" ");
            }
            System.out.println();
        }
    }
}
