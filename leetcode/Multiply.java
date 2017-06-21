/*给定两个非负的整数，把整数看作字符串，返回这两个数的乘积。注意：
  1. num1和num2的长度小于110
  2. num1和num2都只包含数字0-9
  3. num1和num2都不包含任何前导零
*/

public class Multiply {public static String multiply(String num1 , String num2 ) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[ m + n ];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;//
                int sum = mul + pos[p2] ;//注意这里加的是进位，因为在循环之后p2 等于之前的 p1.
                pos[p1] = sum / 10;//p1进位
                pos[p2] = sum % 10;//p2 本位
            }
        }

    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}
    public static void main(String[] args){
        String num1 = "11";
        String num2 = "11";
        System.out.println(multiply(num1,num2));
    }
}
