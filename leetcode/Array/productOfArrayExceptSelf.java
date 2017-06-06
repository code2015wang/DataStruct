/* 给定一个数组nums有n个元素（n > 1）,输出一个数组 output,output[i] 等于数组除了nums[i]之外的其他元素的乘积。要求不使用除法，并且o(n).*/
public class productOfArrayExceptSelf{
    public static int[] productExceptSelf(int[] nums){

    int n = nums.length;
    int[] result = new int[n];
    int left = 1;
    for(int i =0; i< nums.length;  i++){
        if(i >0){
            left = left *nums[i-1];
        }
        result[i] = left;
    }
    int right = 1;
    for(int i = n-1; i>= 0; i-- ){
        if(i < n-1){
            right = right * nums[i+1];
        }
        result[i] = result[i] * right;
    }
    return result;

    }
    public static void main(String[] args){
        int[] nums = new int[] {1,2,3,4};
        int[] result = productExceptSelf(nums);
        for(int res: result){
            System.out.println(res);
        }
    }
}
