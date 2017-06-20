/* 给定一组不同的整数，返回所有可能的子集。如给定数组[1,2,3],返回
   [
   [3],
   [2],
   [1],
   [1,2,3],
   [1,3],
   [1,2],
   [2,3],
   []
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SubSet {
    public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums ,0);
        return list;
    }
    public static void backtrack(List<List<Integer>> list, List<Integer> templist , int[] nums , int start){
        list.add(new ArrayList<>(templist));
        for( int i = start; i< nums.length; i++){
            templist.add(nums[i]);
            backtrack(list, templist , nums, i+1);
            templist.remove(templist.size()-1);
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list.size());
    }
}
