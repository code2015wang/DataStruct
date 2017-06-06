/* 给定一个字符串s，判断该字符串是否为回文，仅考虑字母并忽略大小写。如 "A man , a plan ,a canal : panama" 是回文字符串。“race a car ” 不是回文 。 这道题注意如何判断非字母的情况*/
public class  isPalindrome{
    public static boolean ispalindrome(String s){
        // boolean flag = true ;
        int len = s.length();
        int start = 0;
        int end =  len - 1;
        while(start < end ){
            char first = s.charAt(start);
            char last = s.charAt(end);
            if(!Character.isLetterOrDigit(first)){
                start++;
            } else if (!Character.isLetterOrDigit(last)){
                end --;

            } else {
                if(Character.toLowerCase(first) != Character.toLowerCase(last)){
                    //flag = false;
                    return false;
                }
                start++;
                end--;
            }


        }
        return true;
    }
    public static void main(String[] args){
        String s1 = "a man , a plan , a canal : panama";
        String s2 = " race a car ";
        System.out.println(ispalindrome(s1));
        System.out.println(ispalindrome(s2));
    }
}
