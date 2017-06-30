/* 把1到26映射到A-Z，给定一个字符串数字，返回这个字符串可能的编码个数。如 字符串“12”，可以编码为“AB”，也可以编码为"L".*/
public class DecodeWays {
    public static int numDecodings (String s){
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++){
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if(first >= 1 && first <= 9){
                dp[i] = dp[i] + dp[i-1];
            }
            if(second >= 10 && second <= 26){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        String s = "12";
        System.out.println(numDecodings(s));
    }
}
