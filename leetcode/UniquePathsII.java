/* 机器人从一个m*n的网格左上角要走到右下角，机器人每次只能往下或右。网格中有障碍，我们假设1为障碍，0为空格
   求走到右下角有多少可能路径*/
public class UniquePathsII {
    public int uniquePathsWithObstacles (int[][] obstacleGrid){
        if(obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 1;
                }
                else if (i == 0 && j == 0){
                    obstacleGrid[i][j] = 1;
                }
                else if(i == 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1]*1;

                }
                else if (j == 0){
                    obstacleGrid[i][j] = obstacleGrid[i -1 ][j] * 1;

                }
                else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[row-1][col-1];
    }
}
