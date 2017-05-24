/*求一个数组，连续子数组的最大和。如给定数组[-2,1,-3,4,-1,2,1,-5,4] ,这个连续子数组[4,-1,2,1] 有最大和6.*/
/*这个题目用动态规划来做。*/
public class maximumSubarray {
    public static int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i] + (dp[i-1] > 0? dp[i-1]: 0);
            max = Math.max(dp[i],max);
    }
        return max;

}
    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
