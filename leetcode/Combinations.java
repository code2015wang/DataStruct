/* 给定两个整数n和k，返回1到n中k个数的所有可能的组合。如n=4,k=2返回
   [
   [1,2],
   [1,3]
   [1,4],
   [2,3],
   [2,4],
   [3,4]
]
这里遵循数学公式C(n,k) = C(n-1,k-1)+C(n-1,k)
*/
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class Combinations {
    public List<List<Integer>> combin(int n ,int k){
        if(k == n || k == 0){
            List<Integer> row = new ArrayList<>();
            for(int i = 1; i <= k; ++i){
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer> result = this.combine(n-1,k-1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n-1,k));
        return result;
     }
}
