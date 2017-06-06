/* 给定一个整数集合，返回这个集合的所有子集。如nums = [1,2,3].返回结果为:
   [
   [3],
   [1],
   [2],
   [1,2,3]
   [1,3]
   [1,2]
   [3,2]
   []
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class subsets {
    public static  List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        recurse(result, nums, new Stack<>(),0);
        return result;
    }
    private  static void  recurse(List<List<Integer>> result, int[] nums, Stack path, int position){
        if(position == nums.length ){
            result.add(new ArrayList<>(path));
            return ;

        }
        path.push(nums[position]);
        recurse(result, nums, path, position+1);
        path.pop();
        recurse(result, nums, path, position+1);
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums).toString());
    }
}
