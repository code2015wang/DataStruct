/* 跳石板
   小易来到一条石板路前，每块石板上从1编号为1,2,3,....这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为k的石板，小易单次只能往前跳k的一个约数（不含1和k）步，即跳到k+x（x为非1和本身的约数）的位置。小易当前处在编号为n的石板，它想跳到编号恰为m的石板去，小易向知道至少需要跳跃几次可以到达。
   输入描述：
   输入一行，有两个整数m和n，以空格隔开
   输出描述：
   输出小易最少需要跳跃的步数，如果不能到达输出-1.
*/
import java.util.ArrayList;
import java.util.Scanner;
public class JumpSlate{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(leastJumpTime(n,m));
        }
    }
    public static int leastJumpTime(int n, int m){
        if(n==m){
            return 0;
        }
        int steps = m - n + 1;//算上起点终点
        int[] dp = new int[steps];//规划的量，到达每个位置需要的最小步数
        dp[0] = 0;//起点
        for(int i = 1; i < steps; i++){
            dp[i] = Integer.MAX_VALUE;//初始化，表示后续位置都不能到达
        }
        for(int i = 0; i < steps; i++){
            //0对应n石板，steps-1 = m-n对应m石板
            if(dp[i] == Integer.MAX_VALUE){
                dp[i] = 0;
                continue;
            }
            ArrayList<Integer> list = getAppNums(i + n); // i+n才是石板号
            for(int j = 0; j < list.size(); j++){
                    int x = list.get(j);
                    if(i + n + x <= m){
                        dp[i + x ] = Math.max(dp[i + x],dp[i]+1);
                    }
                }
        }
        if(dp[steps - 1] == 0){
            return -1;
        }else{
            return dp[steps - 1];
        }
    }
    public static ArrayList<Integer> getAppNums(int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 2; i <= Math.sqrt(n);i++){
            if(n % i == 0){
                list.add(i);
                if(n / i != i){
                    list.add(n / i);
                }
            }
        }
        return list;
    }
}
