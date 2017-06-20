/*判断一个输入是否为合法数独输入，数独是由一个给与了提示数字的9*9的网格，我们只需要将其空格上填上数字，使得每一行，每一列以及每一个3*3的网格中没有重复的数字。输入时用"."代表空格，需要填充数字。*/
import java.util.HashSet;
public  class ValidSudoku {
    public boolean isValidSudoku (char[][] board){
        for(int i = 0; i < 9; i++){
            HashSet<character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for(int j = 0; j< 9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[i][j] != '.' && !columns.add(board[j][i])) return false;
                /*以上判断输入是否有重复数字*/
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                /* 计算大网格分成3×3个小网格,每个网格的indx*/
                /* j则是计算每个小网格内的index*/
                if(board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                   return false;
            }
        }
        return true;
    }
}
