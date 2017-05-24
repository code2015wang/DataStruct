/*求一个数组，连续子数组的最大乘积，如给定一个数组[2,3,-2,4]
  连续子数组[2,3]的最大乘积是6.解题思路不是很理解*/
public class maximumProductSubarray {
    public static  int maxProduct(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i]* min ),nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min),nums[i]);
            if(max > result){
                result = max;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
