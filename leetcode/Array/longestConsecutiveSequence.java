/* 给你一个未排序的整数的数组，找到这个数组中最长的连续数组的长度。如：数组[100,4,200,1,3,2] 最长连续元素是[1,2,3,4] 返回4.*/
/*解题思路是：使用一个集合set存入所有的数字，然后遍历数组中的每个数字，如果其在集合中，那麽将其移除，然后分别用两个变量pre和next计算出其前一个数和后一个数，然后在集合中循环查找，如果pre在集合中则继续移除，pre-1，直到pre不在集合中。对next采取同样的方法，那麽next-pre-1就是当前数字的最长连续序列*/
import java.util.HashSet;
public class longestConsecutiveSequence{
    public static int longestConsecutive(int[] nums){
        HashSet set = new HashSet<Integer>();
        int res = 0;
        for(int num :nums){
            set.add(num);
        }
        for(int n :nums){
            if(set.contains(n)){
                int pre = n-1;
                int next = n+1;
                while(set.remove(pre)) --pre;
                while(set.remove(next)) ++next;
                res = Math.max(res,next-pre-1);

            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
/*我们也可以使用hashmap来做，这个思路没有太明白，具体如下：
  刚开始哈希表为空，然后遍历所有数字，如果该数字不在哈希表中，那麽我们分别看其左右数字是否在哈希表中，如果在，则返回其哈希表中映射值，若不在则返回0,然后我们将left+right+1作为当前数字的映射，更新res结果，然后更新d-left和d-right的映射值。*/
