/*康威生命游戏，这是一个细胞自动机，每个位置有两种状态，1为活细胞，0为死细胞，对于每个位置都满足如下条件：
 1. 如果活细胞周围八个位置的活细胞数少于两个，则改位置活细胞死亡。
 2. 如果活细胞周围八个位置有两个或三个活细胞则该位置活细胞仍存活。
 3. 如果活细胞周围有超过三个活细胞，则该位置活细胞死亡
 4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
*/
/*由于题目要求我们使用置换方法in-place来解题，所以我们就不能新建一个相同大小的数组，那麽我们只能更新原有数组，但题目要求所有位置必须同时更新，但在循环程序中我们还是要一个一个位置的更新。那麽当一个位置更新了，这个位置成为其他位置的neighbor时，我们怎么知道其未更新状态那，我们可以使用状态机转换：
  状态0：死细胞转换为死细胞
  状态1：活细胞转换为活细胞
  状态2：活细胞转换为死细胞
  状态3：死细胞转换为活细胞
  最后我们对所有状态对2取余，那麽状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。我们先对原数组进行逐个扫描，对于每个位置扫描其周围8个位置，如果遇到状态1或2,就计数器累加，扫描8个邻居，如果少于两个或大于三个活细胞，而且当前位置是活细胞的话，标记状态2,如果正好由三个活细胞且当前是死细胞的话，标记状态3.完成一边扫描后在对数据进行扫描，对2取余变成我们想要的结果。*/
  public class Solution {
       public void gameOfLife(int[][] board){
       if (board==null || board.length==0){
       return
}
int m = board.length;
int n = board[0].length;
for (int i= 0; i < m; i++){
for (int j = 0; j < n; j++){
int lives = liveNeighbors(board,m,n,i,j);
if (board[i][j]==1 && lives >= 2 && lives <= 3){
board[i][j] = 3;
}
if(board[i][j] == 0 && lives == 3){
board[i][j] = 2 ;
}
}
}
for (int i = 0; i < m; i++){
 for (int j = 0; j < n; j++){
 board[i][j]>>=1;
}
}
}
private int liveNeighbors(int[][] board, int m, int n ,int i, int j ){
int lives = 0;
for (int x =Math.max(i-1,0);x < Math.min(i+1,m-1); x++){
for (int y = Math.max(j-1 ,0); y <=Math.min(j+1,n-1); y++){
lives+=board[x][y] & 1;
}
}
lives -= bo0ard[i][j] &1;
return lives;
}
}
/*另一种解法：
细胞变为“活”，只有两种可能。当它本来为存活态时，邻居有2或3个时保持原来的状态，也就是“活”。还有一种是，当原本为死亡态时，邻居有3个时，也会变为“活”。

其余状态，要么是由存活态变为死亡态，要么就是保持死亡态。

我们通过加上10来保存这个细胞的状态，最后统一进行刷新，这也就是这个问题的核心。

if (count == 3 || (count == 2 && board[r][c] == 1)) board[r][c] += 10;

但因为是数组，所以也有边界。以后再用可变的数组修改吧，挺有意思的题目。两年前就听说了康威生命游戏，大家可以去看看它的Wiki。
*/

public void gameOfLife(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c <board[r].length; c++) {
                int count = countNeighbors(board, r, c);
                if (count == 3 || (count == 2 && board[r][c] == 1))
                    board[r][c] += 10;
            }
        }
        flashBoard(board);
    }

    int countNeighbors(int[][] board, int r, int c) {
        int count = 0;
        for (int row = Math.max(r - 1, 0); row <= Math.min(r + 1, (int)board.length - 1); row++) {
            for (int col = Math.max(c - 1, 0); col <= Math.min(c + 1, (int)board[row].length - 1); col++) {
                if (row != r || col != c)
                    count += board[row][col] % 10;
            }
        }
        return count;
    }

    void flashBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] / 10;
                System.out.println("b = " + board[i][j]);
            }
        }
    }
