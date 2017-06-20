/*给定一组数C和一个目标数T，找到数组中数相加等于目标数的所有情况。C中的每个数字在组合中只能使用一次。所有数字（包括目标数）均为正数，返回集合中不能包括重复的组合。如数组[10,1,2,7,6,1,5] ,目标数 8.，返回
  [
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2 (int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<Integer>(), target,0);
    }
    public void backtrack(List<List<Integer>> list , List<Integer> templist, int[] nums, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(templist));
        else{
            for(int i = start ; i < nums.length; i++){
                if(i > start && nums[i] ==nums[i-1] ) continue;
                templist.add(nums[i]);
                backtrack(list,templist,remain - nums[i],i+1);
                templist.remove(templist.size()-1);
            }
        }
    }
}
