/* 给定一个字符串s，找到这个字符串的最长回文子字符串,如“babad”，返回 “bab”*/
/* 传统验证回文串的方法是两个两个对称验证是否相等，那麽找回文字符串的问题就要以每个字符串为中心，向两边扩散寻找回文串。但要注意奇偶情况，因为回文串的长度可奇可偶，如"bob"是奇数情况，"noon"是偶数情况。*/
public class longestPalindromicSubstring {
    private  static int lo , max ;
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        for( int i = 0; i < len-1; i++){
            extenPalindrome(s,i,i);
            extenPalindrome(s,i,i+1);//这个有 i+1 因此i的上区间为i < len -1
        }
        return s.substring(lo,lo+max);
    }
    public static void extenPalindrome(String s ,int j, int k){
        if(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(max < k-j-1){
            lo = j+1;
            max = k-j-1;
        }
    }
    public static void main(String[] args){
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "bb";
        System.out.println("s1:"+longestPalindrome(s1));

        System.out.println("s2:"+longestPalindrome(s2));
        System.out.println("s3:"+longestPalindrome(s3));
        System.out.println("s4:"+longestPalindrome(s4));
    }
}
