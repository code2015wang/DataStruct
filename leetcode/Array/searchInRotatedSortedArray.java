/*假设以升序排列的数组在预先知道的枢轴上旋转。（即，0 1 2 3 4 5 6 7 可能变成 4 5 6 7 0 1 2），给定一个目标值进行搜索，如果在数组中找到返回其索引，否则返回-1.你可以认为数组中不存在重复。旋转之后数组变成递增和递减两部分，可以分两种情况考虑。*/
public class searchInRotatedSortedArray {
    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] == target ) return mid;
            if(nums[left] <= nums[mid]) {//递增
                if(target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            if(nums[mid] <= nums[right]) {//递减
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid -1;

            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 7;
        int target1 = 8;
        System.out.println(search(nums,target));
        System.out.println(search(nums,target1));
    }
}
