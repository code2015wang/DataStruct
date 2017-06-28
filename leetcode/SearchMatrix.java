/*编写一个函数搜索m*n矩阵中的值，该矩阵具有以下属性：
  1. 每行整数从左到右排序
  2. 每行的第一个整数大于上一行的最后一个整数。
  我们可以考虑二分查找，m*n矩阵可以转换成数组====> 矩阵[x][y] => a[x*n+m]
  数组转换成矩阵m*n=====> a[x] ==> 矩阵[x/n][x%n]
*/
public class SearchMatrix{
    public static boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0,end = row*col - 1;
        while(begin <= end ){
            int mid = (begin +  end ) / 2;
            int mid_value = matrix[mid/col][mid%col];
            if(mid_value == target){
                return true;
            }else if(mid_value < target){
                begin = mid + 1;
            }
            else{
                end = mid -1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }
}
