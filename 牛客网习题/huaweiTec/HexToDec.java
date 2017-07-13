/* 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串(多组同时输入)
   输入描述：
   输入一个十六进制的数值字符串
   输出描述：
   输出概述值的十进制字符串
 */
import java.util.Scanner;
public class HexToDec{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            System.out.println(str.substring(2));
            System.out.println(Integer.parseInt(str.substring(2),16));
            /*
             parset(string ,int) 把字符串解析成第二个参数指定的基数中的有符号整数。
             */
        }
    }
}
