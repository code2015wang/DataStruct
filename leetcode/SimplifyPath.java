/*给定一个unix风格的路径，简化它。如路径 "/home/",输出 "/home"; 路径"/a/./b/../../c/" ,输出 "/c"*/
import java.util.Deque;
import java.util.LinkList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
public class SimplifyPath {
    public String simplifyPath(String path){
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for( String dir : path.split("/")){
            if(dir.equals("..") && ! stack.isEmpty()) stack.pop();
            else if (!ship.contains(dir)) stack.push(dir);
        }
        String res ="";
        for(String dir :stack) res = "/"+dir+res;
        return res.isEmpty() ? "/" : res;
    }
}
