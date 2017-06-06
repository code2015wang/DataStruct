/*给定0,1的字符串，把他们看作二进制字符串，返回两个这样字符串的和。如 a="11",b="1",返回100.*/
public class addBinary{
    public static String addbinary(String a, String b){
        int alen = a.length();
        int blen = b.length();
        int carry = 0;
        StringBuffer result = new StringBuffer();
        for(int i = alen-1, j = blen-1;i >= 0 || j >= 0;i--,j--){
            int ai = (i >= 0) ? a.charAt(i)-'0': 0;
            int bi = (j >= 0) ? b.charAt(j)-'0': 0;
            int sum =(ai+bi+carry) ;
            int val = sum % 2;
            result = result.append(val);
            carry = sum / 2;
        }
        if(carry == 1){
            result = result.append('1');
        }
        return result.reverse().toString();
    }
    public static void main(String[] args){
        String a = "11";
        String b ="1";
        System.out.println(addbinary(a,b));
    }
}
