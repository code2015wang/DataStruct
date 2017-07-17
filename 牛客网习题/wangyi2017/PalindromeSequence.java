/* 回文序列
   如果一个数字序列逆置之后跟源序列是一样的话就称这样的数字序列为回文序列。例如：{1,2,1},{15,78,78,15},{112}是回文序列。
   {1,2,2},{15,78,87,51},{112,2,11}不是回文序列。
   现给出一个数字序列，允许使用一种转换操作：选择任意两个相邻的数，然后从序列中移除他们，并用这两个数的和插入到这两个数之前的位置（只插入一个和）。现在对于给定序列要求求出最少需要多少次操作可以将其变回回文序列。
   输入描述：
   输入为两行，第一行为序列长度 n(1<=n<=50)
   第二行为序列中n个整数item[i],以空格分割
   输出描述：
   输出一个数，表示最少需要转换的次数
   思路：
   left = 0,right = n-1
   1. 比较左边第一个元素和右边第一个元素，如果两数相等，则把他们从数组中移除(这里不是真正移除，而是left++，right++)，否则执行2或者3.如果还有剩余元素，继续1.
   2. 如果左边元素小于右边元素(item[left] < item[right]),则把左边第一个元素加第二个元素的结果作为第二个元素，left++，记一次加法，继续1.
   3. 如果右边的元素小于左边的元素(item[left] > item[right]),则把右边的第一个元素加第二个元素的结果成为第二个元素，rigth--,记一次加法，继续1.
   循环条件为left < right。最后输出计数cont即可
*/
import java.util.Scanner;
public class PalindromeSequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int time = 0;
            while(sc.hasNext()){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++){
                array[i] = sc.nextInt();
                }
            //    int[] array = {1,1,1,3};
        int head = 0, tail = n-1;
            while(head < tail){
                if(array[head] > array[tail]){
                    tail--;
                    array[tail] = array[tail] + array[tail +1];
                    //array[--tail] += array[tail + 1];
                    time++;
                }else if(array[head] < array[tail]){
                    //array[++head] += array[head-1];
                    head++;
                    array[head] = array[head] + array[head-1];
                    time++;
                }else{
                    head++;
                    tail--;
                }
            }
            System.out.println(time);
        }
     sc.close();
    }
}
