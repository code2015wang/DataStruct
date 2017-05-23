/* 给定一个未排序的数组，判断数组是否存在长度为3的递增序列，元素可以相连也可以不连。如给定
   [1,2,3,4,5] return true;
   给定 [5,4,3,2,1] return false
*/
import java.util.Arrays;
import java.util.HashSet;
public class increasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums){

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int n: nums) {
            if(n <= firstMin) firstMin =n;
            else if (n < secondMin ) secondMin = n;
            else if (n > secondMin ) return true;
        }
        return false;
        /*这个判断是正确的，因为到第二个分支的时候能保证n > firstMin
即secondMin > firstMin .到第三个分支的话，保证n > secondMin.即有n > secondMin > firstMin,所以存在3个递增序列。
         */
        /*
        HashSet set = new HashSet<Integer>();
        Arrays.sort(nums);
        for(int n:nums){
            set.add(n);
        }
        if(set.size()>=3) return true;
        else return false;
这种方法不对不能判断[5,4,3,2,1] 为错误。
        */
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
}
