/* 罗马数字转换为整型数，输入范围为1到3999
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
