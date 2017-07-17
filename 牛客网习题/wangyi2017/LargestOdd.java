/* 最大奇数
   小易是一个数学爱好者，并且对于一个数的奇数约数很感兴趣。一天小易遇到这样一个问题:定义函数
   f(x)为x最大的奇数，x为正整数。现给出一个N，需要求出f(1)+f(2)+f(3)+f(4)+....+f(n)
   输入描述：
   输入一个整数n
   输出描述
   输出一个整数，即为f(1)+f(2)+f(3)+....+f(n)
*/
import java.util.Scanner;
public class LargestOdd{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long num = in.nextInt();
        long sum = 0;
        for(long i = num; i > 0; i = i / 2){
            long temp = (i+1) / 2;
            sum = sum + temp * temp;
        }
        System.out.println(sum);
    }
}
