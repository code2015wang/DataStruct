/* 在N*M的草地上，提莫种了k个蘑菇，蘑菇爆炸的威力极大，兰博不想贸然去闯，而且蘑菇是隐形的，只有一种叫做扫描透视镜的物品可以扫描出隐形的蘑菇。于是他回一趟战争学院，买了两个扫描透视镜，一个扫描透视镜可以扫描出（3×3）方格中所有蘑菇，然后兰博就可以清理掉一些隐形蘑菇，问兰博最多可以清理多少个蘑菇？注意：每个方格被扫描一次只能清理掉一个蘑菇。
   输入描述：
   第一行三个整数：N，M，K，M，N代表了草地的大小
   接下来k行，每行两个整数x，y，代表(x,y)处提莫种了一个蘑菇。
   一个方格可以种无穷个蘑菇
   输出描述：
   输出一行，在这一行输出一个整数，代表兰博最多可以清理多少个蘑菇
*/
import java.io.File;
import java.io.FileNoFoundException;
import java.util.Scanner;
public class Third {
    public static int LENGTH  =2;
    public static void main(String[] args){
        int N = 0, M = 0,K;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            K = in.nextInt();
            int[][] num = new int[N][M];
            while( K > 0){
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                if(x < N && y < M){
                    num[x][y]++;
                    K--;
                }
            }
            Point firstPoint = findmaxNum(N,M,num);
            clear(firstPoint,num,N,M);
            Ponit secondPoint findMaxNum(N,M,num);
            System.out.println(firstPoint.conut + secondPoint.conut);
        }
    }
    public static Point getNumInLocation(int N, int M ,int[][] num,int startx,int starty){
        int endx,endy;
        if(startx + LENGTH > N-1){
            endx = N - 1;
        }else{
            endx = startx+LENGTH;
        }
        if(starty+LENGTH > M -1){
            endy = starty+LENGTH;
        }else{
            endy = starty + LENGTH;
        }
        Ponit point = new Ponit();
        ponit.conut  = 0;
        ponit.x = startx;
        ponit.y = starty;
        ponit.endx = endx;
        ponit.endy = endy;
        for(int i = startx; i<=endx; i++){
            for(int j = starty; j <= endy; j++){
                if(num[i][j] > 0){
                    ponit.count++;
                }
            }
        }
        return ponit;
    }
    private static Ponit findMaxNum(int N,int M,int[][] num){
        Ponit point = new Ponit();
        point.conut = 0;
        point.x = 0;
        point.y = 0;
        for(int i = point.x; i <= point.endx;i++){
            for(int j = ponit.x;j <= ponit.endy;j++){
                if(num[i][j] >0 && i < N & j <M){
                    num[i][j]--;
                }
            }
        }
    }
    class point{
        int x;
        int y;
        int endx;
        int endy;
    }
}
