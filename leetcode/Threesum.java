/* 给定n个非负整数数组，在数组中找到a+b+c=0,返回所有结果，
   如数组 S = [-1,0,1,2,-1,-4]
   返回[[-1,0,1],
        [-1,-1,2]
   ]
*/
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
public class Threesum {
    public static List<List<Integer>> threeSum(int[] num){
         Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
    }
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res.size());
    }
}
