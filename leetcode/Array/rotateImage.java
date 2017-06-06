/* 给定一个 n*n的二维矩阵来表示一副图画。输出顺时针旋转90度后的矩阵。*/
public class rotateImage {
    public static void  roate(int[][] matrix){
        for(int i =0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0; i < matrix.length; i++){
            for(int j =0; j< matrix[0].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length -1-j];
                matrix[i][matrix[0].length - 1 -j] = temp;

        }
    }
}
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        // int[][]  res = roate(matrix);
        roate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++ ){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
}
}
