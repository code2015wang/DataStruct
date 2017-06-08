/* 把字符串转换成整数，注意溢出的处理*/
public class MyAtoi {
    public static int myatoi (String str){
        int index =0, sign = 1, total = 0;
        //空字符串
        if(str.length() == 0) return 0;
        //移除空格
        while(str.charAt(index) == ' ' && index < str.length()){
            index ++;
        }
        //处理符号
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = (str.charAt(index) == '+') ? 1: -1;
            index++;
        }
        //处理
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 <digit){
                return sign ==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }

                total = total * 10 +digit;
                index++;
        }
        return total * sign;
    }
    public static void main(String[] args){
        String s1 = "+123";
        System.out.println(myatoi(s1));
    }
}
