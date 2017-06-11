/*给定一个数组和一个target，返回数组中任意三个数之和最接近target的这个和。如[-1,2,1,-4] target = 1. 返回2（-1+2+1=2）
 */
import java.util.Arrays;
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums,int target){
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        for(int i =0; i < nums.length -2; i++){
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target){
                    start++;
                }else {
                    end --;
                }
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
}
