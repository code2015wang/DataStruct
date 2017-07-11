/* 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长？
   输入描述：
   输入数据有多组，每组包含一个字符串s，且保证：1<=s.length<=1000
   输出描述：
   对于每组数据，输出整数，代表最少需要删除的字符数
   实例：
   输入 ：
   abcda
   google
   输出：
   2
   2
*/
import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
          while(sc.hasNext()){
        String s1 = sc.next();
            String s2 = new StringBuilder(s1).reverse().toString();
            int[][] dp = new int[s1.length()+1][s2.length()+1];
            for(int i = 1; i < dp.length; i++){
                for(int j = 1; j < dp[0].length; j++){
                    dp[i][j] = (s1.charAt(i-1) == s2.charAt(j-1)) ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            System.out.println(s1.length()-dp[s1.length()][s2.length()]);
             }
    }
}
