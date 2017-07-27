/* 罗马数字转换为整型数，输入范围为1到3999
   罗马数字采用七个罗马字母作数字，即I(1)、V(5)、X(10)、L(50)、C(100)、D(500)、M(1000)
   1. 相同的数字连写，所表示的数等于这些数字的相加所得的数
   2. 小的数字在大的数字的右边，所表示的数字等于这些数字相加的得到数
   3. 小的数字在大的数子的左边，所表示的数等于大数减小数得到的数
   4. 在一个数的上面画一条横线，表示这个数扩大1000倍。
 */
public class RomanToInt {
    public static int romanToInt(String str){
        int[] num = new int[str.length()];
        int result = 0;
        for(int i =0; i< str.length(); i++){
            switch(str.charAt(i)){
            case 'M':
                num[i] = 1000;
                break;
            case 'D':
                num[i] = 500;
                break;
            case 'C':
                num[i] = 100;
                break;
            case 'L':
                num[i] = 50;
                break;
            case 'X':
                num[i] = 10;
                break;
            case 'V':
                num[i] = 5;
                break;
            case 'I':
                num[i] = 1;
                break;
            }
        }
        for( int i = 0; i< num.length -1 ; i++){
            if(num[i] >=  num[i+1]){
                result = result +num[i];
            }else {
                result = result -num[i];
            }
        }
        return result+num[num.length-1];
    }
    public static void main(String[] args){
        String str = "XXII";
        String str1 = "MD";
        System.out.println(romanToInt(str));
        System.out.println(romanToInt(str1));
    }
}
