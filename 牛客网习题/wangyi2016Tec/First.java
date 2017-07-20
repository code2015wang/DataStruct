/* 小易经常沉迷域网络游戏。有一次，他在玩一个打怪升级的游戏。他的角色的初始值为a。在接下来的一段时间内，它将会依次遇到n个怪物，每个怪物的防御力为b1,b2,b3,b4,....bn.如果遇到的怪物防御力bi等于小易当前能力值c，那麽它能轻松打败怪物，并且使自己的能力增加bi。如果bi大于c，那麽它也能打败怪物，但它的能力只能增加bi与c的最大公约数。那麽问题来了，在一些列的锻炼后，小易的最终能力值是多少？
   输入描述：
   对于每组数据，第一行的两个整数n表示怪物的数量和a表示小易的初始能力
   第二行n个整数，b1,b2,b3,b4....bn表示每个怪物的防御力
   输出描述：
   对于每组数据，输出一行，每行仅包括一个整数，表示小易的最终能力值。
 */
import java.util.Scanner;
public class First{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int init = in.nextInt();
            int[] master = new int[n];
            for(int i = 0; i < n; i++){
                master[i] = in.nextInt();
                if(init > master[i]){
                    init = init + master[i];
                }else{
                    init = init + maxDivisor(init ,master[i]);
                }
            }
            System.out.println(init);
        }
        in.close();
    }
    public static int maxDivisor(int n, int m){
        if(m % n == 0){
            return n;
        }else{
            return maxDivisor(m % n,n);
        }
    }
}
