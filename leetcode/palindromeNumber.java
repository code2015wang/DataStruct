/* 判断一个数字是否为回文数字，注意溢出情况同时不能把整数转换成字符串*/
public class palindromeNumber {
    public static  boolean isPalindromeNumber(int x){
        if(x < 0 ||(x!=0 && x%10 == 0)  ) return false;
        int rev = 0;
        /* while(x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        if(x == rev || x == rev /10){
            return true;
            }
        return false;
        */
        //注释的这段代码没有使用额外的变量，但不容易让人理解最后的判断条件
        //下面的代码更容易理解点
        int result = x;
        while(result > 0){
            rev = rev * 10 + result % 10;
            result = result / 10;
        }

        return (rev == x);
    }
    public static void main(String[] args){
        int x1 = -11;
        int x2 = 230;
        int x3 = 11;
        System.out.println(isPalindromeNumber(x1));

        System.out.println(isPalindromeNumber(x2));
        System.out.println(isPalindromeNumber(x3));
    }
}
/* (x!=0 && x%10 ==0 ) 情况是x是10的倍数，此时不是回文
   注意最后，判断条件是(x== rev || x== rev/10)
*/
