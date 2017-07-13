/* 明明想在学校中请一些同学一起做问卷调查，为了实验的客观性，他先用计算机生成N个1到1000之间的随机数，对于重复的数字只保留一个，把其他相同的数去掉，不同的数对应不同的学生学号。然后再把这些数从小到大排序，按照排好的顺序找同学左调查。请协助明明完成“去重”和排序工作。
   输入描述：
   输入多行，先输入随机数的个数，在输入相应个数的整数
   输出描述：
   返回多行，处理结果
*/
import java.util.Scanner;
import java.util.TreeSet;
public class Random{
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()){
            TreeSet<Integer> set = new TreeSet<Integer>();
            int n = in.nextInt();
            for(int i = 0; i < n ; i++){
                set.add(in.nextInt());
            }

        for(Integer i : set){
            System.out.println(i);
        }
        }
    }
}
