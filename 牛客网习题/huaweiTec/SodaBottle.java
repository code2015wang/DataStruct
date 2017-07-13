/* 有这样一道智力题：某商店规定：三瓶汽水可以换一瓶汽水。小张手上有十个空汽水瓶。她最多可以换多少瓶汽水喝？答案是5瓶。方法如下：先用9个空瓶子换3瓶汽水喝，喝掉以后4个空瓶子，用3个再换一瓶，喝掉这瓶，这时候剩2个空瓶子，然后让老板先借给你一瓶，喝掉以后，用3个空瓶子换一瓶还给老板。如果小张手上有n个空汽水瓶，最多换多少瓶汽水喝？
   输入描述：
   输入文件最多包含10组测试数据，每行数据占一行，仅包含一个正整数n（1<=n<=100）,表示小张手上的空汽水瓶。n=0表示输入结束，你的程序不应当处理这一行。
   输出描述：
   对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数，如果一瓶也喝不到，输出0.
*/
import java.util.Scanner;
public class SodaBottle {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int blank = in.nextInt();
            if(blank == 0){
                break;
            }else{


            int drink = 0;
            int remain;
            if(blank > 0 && blank <= 100){
                if(blank == 1){
                    drink = 0;
                }else if(blank == 2){
                    drink = 1;
                }
                while(blank > 2){
                    drink = drink + blank / 3;
                    remain = blank % 3;
                    blank = blank / 3 + remain;
                    if(blank == 2){
                        drink ++;
                    }
                }
            }
            System.out.println(drink+"");
        }
        }
    }
}
