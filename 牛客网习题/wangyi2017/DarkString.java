/* 黑暗的字符串
   一个只包含'A',"B",'C'的字符串，如果存在某段长度为3的连续子串中恰好'A','B','C'各一个，那麽这段字符串就是纯净的，否则这段字符串是黑暗的。如：BAACAACCBAAA连续子串中包含了'A','B','C'各一个，所以是纯净的字符串
   AABBCCAABB不存在一个长度为3的连续子符串包含'A','B','C',所以是暗黑字符串。
   你的任务就是计算出长度为n的字符串(只包含'A','B','C'),有多少个暗黑的字符串。
   输入描述：
   输入一个整数n，表示字符串长度
   输出描述：
   输出一个整数表示有多少个暗黑字符串
*/
import java.util.Scanner;
public class DarkString{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(dp(n));
        }
    }
    public static long dp(int n ){
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 3;
        dp[2] = 9;
        for(int i = 3; i <= n; i++ ){
            dp[i] = 2 * dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
}
