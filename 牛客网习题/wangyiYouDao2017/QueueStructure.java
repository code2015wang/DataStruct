/* 构造队列
   小明同学把１到ｎ这ｎ个数按照一定的顺序放入一个队列Q中。现在他对Ｑ执行如下程序
   ```
   while(!Q.empty())   //队列不空，执行循环
   {
   int x = Q.front();//取出当前对头的值ｘ
   Q.pop();//弹出当前队头
   Q.push(x);//把ｘ放入队尾
   x = Q.front();//取出这时候的队头的值
   printf("%d\n",x);
   Q.pop()//弹出这时候的队头
}
```
做取出队头值的操作的时候，并不弹处当强队头。
小明发现，这段程序恰好按顺序输出了1,2,3,4,...,n.现在小明想让你构造出原始队列，你能做到吗?
输入描述：
第一行一个整数Ｔ(T<= 100) 表示数据组数，每组数据输入一个数n(1<= n <= 100000),输入的所有ｎ之和不超过200000
输出描述：
对于每组数据，输出一行，表示原始的队列。数据之间空格隔开，不要在行末输出多余的空格
输入例子：
４
１
２
３
10
输出例子;
1
2 1
2 1 3
8 1 6 2 10 3 7 4 9 5
*/
/* 利用逆向思维。首先根据题目要求，我们构造的队列是这个样子，将队头的数拿到队尾，然后在弹出队头的数。这样子下去最终弹出来的序列是１到ｎ，那么我们可以逆向考虑，从结果倒推。比如我们的ｎ＝３，最后的操作是将３从队头拿到队尾，然后再弹出队头３，那我们到过来就是将３插入队头然后将３从队尾拿到队头。我们在看倒数第二次操作是将３从队头拿到队尾然后在弹出２，到过来就是将２插入队头，然后在将３从队尾拿到对头。倒数第三次是将２从对头拿到对尾，然后在弹出１。到过来就是将１插入对头然后在将２从对尾拿到对头。*/
import java.util.Scanner;
import java.util.LinkedList;
public class QueueStructure{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();//多少组数据
        for(int i = 0; i < k ; i++){
            int n = in.nextInt();//从１到ｎ的ｎ个数
            LinkedList<Integer> res = new LinkedList<Integer>();
            res = structure(n);
            for(int j = 0; j < n-1; j++){
                System.out.print(res.removeFirst()+" ");
            }
            System.out.println(res.removeFirst());
        }
    }
    private  static  LinkedList<Integer> structure(int n){
        LinkedList<Integer> temp = new LinkedList<Integer>();
        for(int i = n; i >=  1; i--){
            temp.addFirst(i);
            temp.addFirst(temp.removeLast());
        }
        return temp;
    }
}
