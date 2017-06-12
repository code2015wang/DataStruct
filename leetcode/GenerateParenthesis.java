/* 生成括号，给定n，编写函数生成良好的括号组成的所有集合。如n = 3的结果为：
   [
   "((()))",
   "(()())",
   "(())()",
   "()(())",
   "()()()"
   ]*/
import java.util.List;
import java.util.ArrayList;
public class GenerateParenthesis {
    public static  List<String> generateParenthesis(int n){
        List<String> list = new ArrayList<String>();
        generateOneByOne("" ,list , n, n);
        return list;
    }
    public static  void generateOneByOne(String sublist ,List<String> list, int left, int right){
        if(left > right) return;
        if(left > 0){
            generateOneByOne(sublist+"(",list,left-1,right);
        }
        if(right >0){
            generateOneByOne(sublist+")",list,left,right-1);
        }
        if(left==0 && right == 0){
            list.add(sublist);
            return ;
        }
    }
    public static void main(String[] args){
        int n=3;
        ArrayList<String> res = (ArrayList<String>)generateParenthesis(n);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
