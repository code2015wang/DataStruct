/* 把一个整型数转换成罗马数字。输入数字的范围为1到3999
   罗马数字只有7个符号，分别为I,V,X,L,C,D,M 分别对应1,5,10,50,100,500,1000.
   计数规则：
   1. 相同数字连写，所表示的数等于这些数字的相加所得的数
   2. 小的数字在大数的右边，所代表的数等于这些数相加得到的数
   3. 小的数字在大数的左边，所代表的数等于大数减小数得到的数
   4. 正常使用，连写的数字不能超过三次
   5. 在一个数的上面画一条横线，表示这个数扩大1000倍。
*/
public class IntToRoman {
    public static String intToRoman(int num){
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++){
            while(num >= value[i]){
                num = num - value[i];
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        int num = 999;
        int num2 = 10;
        System.out.println(intToRoman(num2));
        System.out.println(intToRoman(num));
    }
}
