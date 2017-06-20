/*给定包含重复元素的数字集合，返回所有的全排列。如数组[1,1,2],返回
  [
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class PermuteUnique {
    public static  List<List<Integer>> permuteUnique (int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }
    public static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] used) {
        if(templist.size() == nums.length){
            list.add(new ArrayList<>(templist));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                templist.add(nums[i]);
                backtrack(list,templist,nums,used);
                templist.remove(templist.size() -1);
            }
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> list =permuteUnique(nums);
        System.out.println(list.size());

    }
}
