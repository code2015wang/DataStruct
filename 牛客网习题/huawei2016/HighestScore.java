/* 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师询问。当然，老师有时候需要更新某位同学的成绩。
   输入描述：
   输入包括多组测试数据
   每组输入第一行是两个整数N和M（0<N<=3000,0<M<5000）,分别代表学生数目和操作的数目
   学生ID编号从1编到N
   第二行包含N个整数，代表这N个学生的初始成绩，其中第i个代表ID为i的学生的成绩
   接下来又M行，每一行有一个字符c（只取'Q'或’U‘）和两个正整数A，B，当C为'Q'的时候，表示这是一条询问，它询问ID从A到B（包括A，B）的学生中，成绩最噶的是多少
   当c为’U'的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更新为B
   输出描述：
   对于每一次询问操作，在一行里面输出最高成绩
*/
import java.util.Scanner;
public class HighestScore{
    public static void main(String[] args){
        int M = 0, N = 0;
        int i;
        int A =0, B = 0;
        String  c = null;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            int[] score = new int[N];
            for(i = 0; in.hasNext() && i < N; i++){
                score[i] = in.nextInt();
            }
            for( i =0; in.hasNext() && i < M; i++){
                c = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c,A,B,score);
            }
        }
    }
    private static void process(String c, int a ,int b, int[] score){
        int begin,end;
        if(c.equals("Q")){
            end = Math.max(a,b);
            begin = Math.min(a,b)-1;
            int max = score[begin];
            for(int i = begin; i < end; i++){
                if(max < score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
                score[a-1] = b;
            }
        }
    }
