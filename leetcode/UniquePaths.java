/*机器人位于m*n网格的左上角，机器人只能在任何时间点向下或向右移动，机器人正试图到达网格的右下角，有多少条可能的路径。
  我们假设
  1. 当（n == 0 ||  m== 0） 机器人总返回1
  2. 不能往左或上
  3. 对于所有其他细胞，result = uniquePath(m-1,n) + uniquePaths(m ,n-1)
  本题用DP方法正好。
*/
public class UniquePaths {
    public int uniquePaths(int m , int n){
        Integer[][] result = new Integer[m][n];
        for(int i = 0; i < m; i++){
            result[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            result[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n ; j++){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[m-1][n-1];
    }
}
