/* 给定不同数字的集合，返回所有可能的排列。如[1,2,3]具有一下排列：
   [
   [1,2,3],
   [1,3,2],
   [2,1,3],
   [2,3,1]
   [3,1,2],
   [3,2,1]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Permute {
    public static List<List<Integer>> permute (int[] nums){
        List<List<Integer>> list =new ArrayList<>();
        backtrack(list , new ArrayList<Integer>(), nums);
        return list;
    }
    public  static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums){
        if(templist.size() == nums.length){
            list.add(new ArrayList<>(templist));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                backtrack(list,templist,nums);
                templist.remove(templist.size()-1);
            }
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list = permute(nums);
        System.out.println(list.size());
    }
}
