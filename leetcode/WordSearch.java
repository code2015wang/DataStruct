/* 给定一个2D的矩阵和一个单词，找到这个单词是否存在于网格中。该单词可以由顺序相邻的字母构成，其中相邻单元是水平或垂直的单元。相同的字母可能不会被多次使用。如board = [
   ['A'.'B','C','E'],
   ['S','F','C','S'],
   ['A','D','E','E']
]
word = 'ABCCED' return true;
word = 'SEE' return true
word = 'ABCB' return false
*/
public class WordSearch {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word){
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j] && search(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(search(board,word,i-1,j,index+1)||
           search(board,word,i+1,j,index+1)||
           search(board,word,i,j-1,index+1)||
           search(board,word,i,j+1,index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }

}
