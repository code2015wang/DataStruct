/* 给定一个n个对象颜色为红，白或蓝的数组，对其进行排序，使其相同颜色的对象相邻，颜色为红，白，蓝。在这里，我们使用0,1,2的整数分别表示红色，白色和蓝色。
 */
public class SortColor {
    public void sortColor(int[] nums){
        int num0 = 0,num1 = 0, num2 = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) ++num0;
            else if(nums[i] == 1) ++num1;
            else(nums[i] == 2) ++num2;
        }
        for(int i = 0; i < num0; i++) nums[i] = 0;
        for(int i = 0; i < num1; i++) nums[num0+i] = 1;
        for(int i = 0; i < num2; i++) nums[num0+num1+i] = 2;
    }
}
