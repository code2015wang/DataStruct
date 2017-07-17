/* 数字翻转
   对于一个整数x，定义操作rev(x)为将x按位数反转过来，并且去掉前导0.例如，
   如果 x = 123,则rev(x)= 321
   如果 x = 100,则rev(x) = 1;
   现在给出整数x和y，要求rev(rev(x)+rev(y))为多少？
   输入描述：
   输入为一行，x，y，以空格隔开
   输出描述：
   输出rev（rev（x）+rev（y））的值
*/
import java.util.Scanner;
public class ReverseNum {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if(x < 1 || x > 1000 || y < 1 || y > 1000) return;
        System.out.println(Rev(Rev(x)+Rev(y)));
    }
    private static int Rev(int x){
        return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
    }
}
