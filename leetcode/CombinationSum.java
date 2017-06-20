/* 给定一组候选数C(无重复)和目标数(T),找到c中所有独特的组合，使其和与T相等。组合可以从候选数中多次选择同一个数*/
/* 给定候选集[2,3,7]和目标7,返回
   [
   [7],
   [2,2,3]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum {
    public static  List<List<Integer>> combinationSum (int[] candidates , int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    public  static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] candidates, int remain , int start ) {
        if(remain < 0) return ;
        else if (remain == 0) list.add(new ArrayList<>(templist));
        else {
            for(int i = start; i < candidates.length; i++){
                templist.add(candidates[i]);
                backtrack(list , templist, candidates, remain - candidates[i], i);
                templist.remove(templist.size() -1);
            }
        }
    }
    public static void main(String[] args){
        int[] candidates = new int[]{2,3,7};
        int target = 7;
        List<List<Integer>> list = combinationSum(candidates, target);
        System.out.println(list.size());
    }
}
