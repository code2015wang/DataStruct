/* 把一个字符串的大写字母放在祖父串的后面，各个字符的相对位置不变，且不能申请额外的空间*/
import java.util.Scanner;
public class StringPosition{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(getResult(str));
        }
    }
    public static String getResult(String str){
        return str.replaceAll("[A-Z]","")+str.replaceAll("[a-z]","");
    }
}
