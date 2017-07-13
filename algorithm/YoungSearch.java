/* 有一个m行n列的矩阵，在程序里我们可以使用二维数组来表示，而这个矩阵行是递增的，每一列也是递增的。这种行和列是递增的结构叫杨氏矩阵。在这个矩阵中查找叫杨式矩阵查找*/
public class YoungSearch{
    private int[][] array;
    public YoungSearch(int[][] array){
        this.array = array;
    }
    public boolean recursionSearch(int x,int y,int target){
        if(x == array.length || y == array.length){
            return false;
        }
        if(target < array[x][y]){
            return false;
        }
        if(target == array[x][y]){
            System.out.println(String.format("x:%d,y:%d",x,y));
            return true;
        }
        return recursionSearch(x+1,y,target) || recursionSearch(x,y+1,target);
    }

}
