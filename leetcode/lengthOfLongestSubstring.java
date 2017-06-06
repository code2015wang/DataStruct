/*求一个字符串的最长不重复字串,如 "abcabcbb",返回"abc";"bbbbb",返回"b";"pwwkew",返回"wke"*/
import java.util.HashSet;
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        int i =0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,set.size());
            } else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
    public static void main(String[] args){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
