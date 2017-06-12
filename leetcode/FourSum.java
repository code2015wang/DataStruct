/* 给定一个数组和一个target，在数组中寻找4个数之和等于target，返回所有结果。如S = {1,0,-1,0,-2,2} ，target = 0,返回结果为
   [
   [-1,0,0,1],
   [-2,-1,1,2],
   [-2,0,0,2]
]
*/
import java.util.ArrayList;
import java.util.Arrays;
public class FourSum {
    public static void fourSum(int[] sum, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i =0; i< num.length-3; i++) {
            if(num[i]+num[i+1]+num[i+2]+num[i+3] > target) break;
            if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3] < target) continue;
            if(i > 0 && num[i] == num[i+1]) continue;
            for(int j = i+1; j < num.length -2 ;j++) {
                if(num[j]+num[j+1]+num[j+2]> target) break;
                if(num[i]+num[j]+num[j+1]+num[j+2] < target) continue;
                if(j>i+1 && num[j]==num[j+1] ) continue;
                int low = j+1, high = num.length-1;
                while ( low < high ) {
                    int sum = num[i] + num[j] + num[j+1] + num[j+2];
                    if(sum == target) {
                        ans.add(Arrays.asList(num[i],num[j],num[j+1],num[j+2]));
                        while(low < high && num[low] == num[low+1] ) low++;
                        while(low <high && num[high] == num[high-1]) high--;
                        }
                    else if(sum < target ) low++;
                    else high --;
        }



    }
        }
            return ans;
    }
