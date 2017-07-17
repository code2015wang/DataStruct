/* 优雅的点
   有一个圆心在坐标原点的圆。知道圆半径的平方。我们认为在圆上的点且横纵坐标都是整数的点是优雅的。现设计一个算法计算优雅点出现的个数。
   如半径的平方如果为25
   优雅点就有：(+/-3,+/-4),(+/-4,+/-3),(+/-5,0),(0,+/-5)，一共12个点
   输入描述：
   输入一个整数，即为圆半径的平方，范围在32位int范围内
   输出描述：
   输出一个整数，即优雅点的个数
   我们从优雅点的定义可以看到，我们需要考虑圆与坐标轴的交点和斜边为半径的直角三角形。
*/
import java.util.Scanner;
public class GracePonit{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //int conut = 0;
        while(in.hasNext()){
            int conut = 0;
            int n = in.nextInt();
            for(int i = 1; i*i < n; i++){
                int y = (int)Math.sqrt(n - i*i);
                if(i*i+y*y == n){
                    System.out.println(i+" "+ y);
                    conut++;
                }
            }
            conut = conut * 4;
            int x = (int)Math.sqrt(n);
            if(x*x == n){
                conut = conut + 4;
            }
            System.out.println(conut);
        }
        in.close();
    }
}
