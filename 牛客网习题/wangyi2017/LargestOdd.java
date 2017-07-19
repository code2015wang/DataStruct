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

/* 因为奇数的最大奇数就是自己，对于偶数我们只能一直除2知道得到一个奇数即为最大奇数。
   比如1 2 3 4 5 6 7 8 9 10
   即n=10,此时奇数为1 3 5 7 我们把这几个奇数相加然后n/2
   得到第二轮序列1 2 3 4 5 分别对应上次的 2 4 6 8 10 这五个偶数，这时我们再加1 3 5
   细节问题：
   当n为偶数，就有n/2个奇数，根据等差数列求和即为(n/2)*(n/2),此时n为偶数有(n/2)*(n/2)=((n+1)/2)*((n+1)/2)
   当n为奇数，有(n+1)/2个奇数，此时奇数和为((n+1)/2)*((n+1)/2)
   因此两种情况可以用一个等式来总结。*/
