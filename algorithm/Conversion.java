/* 十进制转换成二进制，八进制 ，十六进制*/
import java.util.Stack;
import java.util.Scanner;
public class Conversion {
    public static String toBinary(int num){
        return Integer.toBinaryString(num);
    }
    public static String toOctal(int num){
        return Integer.toOctalString(num);
    }
    public  static String toBinary1(int num){
        Stack stack = new Stack();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        if(num < 2){
            sb.append(num);
        }else{
            while(num > 0){
             result = num % 2;
             num = num / 2;
             stack.push(result);
        }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static String  toHex(int num){
        String[] temp = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        int result = 0;
        if(num < 16){
            sb.append(temp[num]);
        }else{
            while(num > 0){
                result = num % 16;
                num = num / 16;
                stack.push(temp[result]);
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }

            return sb.toString();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入正整数：");
          int input = scanner.nextInt();
        // int input = 14;
        System.out.println(toBinary1(input));
        System.out.println(toBinary(input));
        System.out.println(toOctal(input));
        System.out.println(toHex(input));
        System.out.println(Integer.toHexString(input));
    }
}
