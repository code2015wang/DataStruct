/* 洗牌
   洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。现在需要洗２ｎ张牌，从上到下依次是第１张，第２张，第３张一直到第ｎ张。首先我们把这２ｎ张牌分成两堆，左手拿着第一张到第ｎ张（上半堆），右手拿着第ｎ＋１张到第２ｎ张。接着开始洗牌，先放右手最后一张，再放左手的最后一张，接着放右手的倒数第二张，再放左手的倒数第二张。直到最后放下左手的最后一张。接着把牌合并起来就可以了。例如有６张牌，最开始的序列是1,2,3,4,5,6.首先分两组，左手拿１,2,3;右手拿4,5,6.洗牌的过程中按顺序放下６,3,5,2,4,1.把这六张牌再次组合成一组牌后，我们按照从上往下的顺序看这组牌就变成了１,4,2,5,3,6.现在给出一个原始牌组，请输入这幅牌洗牌ｋ次后从上到下的序列。
   输入描述：
   第一行一个数Ｔ（Ｔ<=100）,表示数据组数。对于每组数据，第一行两个数n,k(1<=n,k<=100),接下来一行有２ｎ个数a1,a2,....a2n.表示原始牌组从上到下的序列
   输出描述：
   对于每组数据，输出一行，最终的序列，数字之间用空格隔开，不要在行末输出多余的空格。
*/
import java.util.Scanner;
public class ShuffleCard{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] card = new int[2*n];
            for(int j = 0; j < 2*n; j++){
                card[j] = in.nextInt();
            }
            for(int v = 0; v < k; v++){
                card = shuffle(card);
            }
            for(int w = 0; w < card.length - 1; w++){
                System.out.print(card[w]+" ");
            }
            System.out.println(card[card.length - 1]);
        }
        in.close();
    }
    private static int[]  shuffle(int[] card){
        int[] temp = new int[card.length];
        int len = (card.length - 1) / 2;
        //int send = card.length - 1;
        int index = card.length - 1;
        for(int i = 0; i <= len; i++){
            temp[index--] = card[card.length-1 - i];
            temp[index--] = card[len - i];
        }
        return temp;
    }
}
