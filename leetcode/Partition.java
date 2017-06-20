/* 给定一个字符串s，分区使分区的每个子字符串都是回文，返回所有可能的回文。如s= "aab",
   返回 [
   ["aa","b"],
   ["a","a","b"]
]
*/
import java.util.List;
import java.util.ArrayList;
public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(),s,0);
        return list;
    }
    public void backtrack(List<List<String>> list, List<String> templist, STring s, int start){
        if(start == s.length()){
            list.add(new ArrayList<>(templist));
        } else{
            for(int i = 0; i < s.length(); i++){
                if(isPalindrome(s,start,i)){
                    templist.add(s.substring(start,i+1));
                    backtrack(list,templist,s,i+1);
                    templist.remove(templist.szie()-1);
                }
            }
        }
    }
    public boolean isPalindrome(String s ,int low , int high) {
        while(low < high){
            if(s.charAt(low++) != s.charAt(high --)) return false;
            return true;
        }
    }
}
