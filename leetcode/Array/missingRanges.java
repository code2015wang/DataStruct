/* 给定一个排序好的整数数组和一个区间[low,upper],返回数组在这个区间中缺失的一部分。如给定 [0,1,3,50,75] ,lower = 0,upper = 99,返回[2,4-74,76-99]*/
import java.util.ArrayList;
import java.util.List;
public class missingRanges {
    public static List<String> findMissingRange(int[] nums,int lower, int upper){
        ArrayList<String> result = new ArrayList<String>();
        for(int  i = 0; i <= nums.length; i++){
            long start = i == 0 ? lower : (long)nums[i-1]+1;
            long end = i==nums.length ? upper :(long) nums[i]-1;
            addMissing(result, start, end);
        }
        return result;
    }
    public static void addMissing(ArrayList<String> result ,long start, long end){
        if(start> end) {
            return;
        }else if(start == end){
            result.add(Long.toString(start));
        }else{
            result.add(start+"->"+end);
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        ArrayList<String> result =(ArrayList<String>) findMissingRange(nums, lower, upper);
        for(String res: result){
            System.out.println(res);
        }
    }
}
/*这个题的思路是遍历数组，但注意i == 0时，start = lower.其余时候 satrt = nums[i-1]+1;当 i == nums.length 时 end = upper，其余时候 end = nums[i+1]-1;然后是把[start ,end] 插入 ArrayList。在插入是注意判断一下 start == end的情况 。当start > end的情况 不做任何处理.*/
