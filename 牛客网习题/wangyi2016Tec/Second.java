/* 兰博教训提莫后，然后和提莫讨论起约德尔人。谈起约德尔人，自然少不了一个人，那就是黑默丁格---约德尔人历史上最伟大的科学家。提莫说，黑默丁格最近在思考一个问题：黑默丁格有三个炮台，炮台能攻击到距离它R的敌人（两点之间的距离为两点连续的距离，例如(3,0),(0,4)之间的距离是5），如果一个炮台能攻击到敌人，那麽对敌人造成1×的伤害。黑默丁格将三个炮台放在N*M方格中的点上，并且给出敌人的坐标，问那麽敌人受到伤害会多大？
   输入描述：
   第一行9个整数，R，X1,y1,x2,y2,x3,y3,x0,y0,R代表炮台攻击的最大距离,(x1,y1),(x2,y2),(x3,y3)代表三个炮台的坐标，(x0,y0)代表敌人的坐标
   输出描述：
   输出一行，这一行代表敌人承受的最大伤害（如果每个炮台都不能攻击到敌人，输出0x）
*/
import java.util.Scanner;
public class Second {
    public static void main(String[] args){


    Scanner in  = new Scanner(System.in);
    while(in.hasNext()){
        int r = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        long R = r * r;
        int res = 0;
        long dis1 = getDistance(x1,y1,x0,y0);
        long dis2 = getDistance(x2,y2,x0,y0);
        long dis3 = getDistance(x3,y3,x0,y0);
        //long dis4 = getDistance(x4,y4,x0,y0);
        if(dis1 <= R){
            res++;
        }
        if(dis2 <= R){
            res++;
        }
        if(dis3 <= R){
            res++;
        }
        System.out.println(res+"x");
    }
    }
    public static long getDistance(int x1,int y1 ,int x0, int y0){
        long dis = (x1-x0)*(x1-x0)+(y1-y0)*(y1-y0);
        return dis;
    }
}
