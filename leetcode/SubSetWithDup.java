/* 给定一个数组，数组有重复元素，返回数组的所有子集。如数组[1,2,2],返回
   [
   [2],
   [1],
   [1,2,2],
   [2,2],
   [1,2],
   []
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SubSetWithDup {
    public static  List<List<Integer>> subsetWithDup (int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums , 0);
        return list;
    }
    public  static void backtrack(List<List<Integer>> list , List<Integer> templist, int[] nums , int start) {
        list.add (new ArrayList<>(templist));
        for( int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            templist.add(nums[i]);
            backtrack(list,templist,nums, i+1);
            templist.remove(templist.size()-1);
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> list = subsetWithDup(nums);
        System.out.println(list.size());
    }
}
