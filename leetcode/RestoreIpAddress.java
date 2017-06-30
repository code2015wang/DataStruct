/* 给定一个字符串仅包含数字，返回其中包含的合法ip。返回ip的顺序无关紧要。如 “25525511135”，返回["255.2255.11.135","255.255.111.35"]*/
import java.util.List;
import java.util.ArrayList;
public class RestoreIpAdress {
    public List<String> restoreIpAddress(String s){
        List<String> res = new ArrayList<>();
        int len = s.length();
        for(int i = 1; i < 4 && i < len - 2; i++){
            for(int j = i+1; j < i + 4 && i < len - 1; j++){
                for(int k = j+1; j < k + 4 && j < len; j++){
                    String s1 =s.substring(0,i),s2 = s.substring(i,j),s3 = s.substring(j,k),s4 = s.substring(k,len);
                    if(isValid(s1) &&  isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length() > 3 || s.length() == 0 || (s.chartAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255)
            return false;
        return true;
    }
}
