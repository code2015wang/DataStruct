/* 从 1到n有 n! 个全排列，给定一个n和k，返回1到n的全排列中第k个排列。排列规则如下：
   如 n = 3,
   1. “123”
   2. “132”
   3. “213“
   4. ”231“
   5. ”312“
   6. ”321“
*/
import java.util.List;
import java.util.ArrayList;
public class PermutationSequence {
    public  static String getPermutation(int n ,int k){
        int pos = 0;
        int[] factorial = new int[n+1];
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int sum = 1;
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        //factorial[] = {1,1,2,6,24,....,n!}
        for(int i =1; i <= n; i++){
            numbers.add(i);
        }
        //numbers = {1,2,3,4}
        k--;
        for(int i = 1; i <= n; i++){
            System.out.println("k:"+k+" "+"f(n):"+ factorial[n-1]);
            int index = k / factorial[n-1];
            System.out.println("index:"+ index);
            sb.append(String.valueOf(numbers.get(index)));
            k-=index*factorial[n-i];
        }
        return String.valueOf(sb);
    }
    public static void main(String[] args){
        int n = 3, k = 3;
        System.out.println(getPermutation(n,k));
    }
}
