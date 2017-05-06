# 2017-5-4

##  消失数字

> 给定一个包含从 0,1,2,3,4,5，....，n中取n个不同的数字的数组，找到数组中缺少的数字。例如，给定nums=[0,1,3],返回2

> 注意1.数组中每个数都不同，所以数组长度可以知道n的范围；2.只缺少一个数字

代码如下：

```java
public class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
         sum=sum+i;            
        }
        return ((n*(n+1)/2)-sum);
    }
}
```

## 第一个坏的版本

> 如果你是一个产品经理，目前领导一个团队开发新的产品。不幸的是，最新的版本产品未能通过质量检测。由于每个版本是基于以前的版本开发的，所以坏的版本之后的所有版本也不是好的。假设你有n个版本[1,2,3,4,....,n],逆向找到第一个版本，这导致了一下所有的错误。你得到一个API isBadVersion(version),它会返回是否版本不好。实现一个功能来找到第一个版本。尽可能的减少对API的盗用次数。

> 题目中提到要求调用API的次数尽可能的少，因此我们使用折半查找法

代码如下：

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       int start = 1, end = n;
    while (start < end) {
        int mid = start + (end-start) / 2;
        if (!isBadVersion(mid)) start = mid + 1;
        else end = mid;            
    }        
    return start;
    }
}
```

## 移动0

> 给定一个数组nums，写一个函数将所有0移动到最后，同时保持非零元素的相对顺序。例如，给定nums=[0,1,0,3,12],在调用函数之后，nums应为[1,3,12,0,,0]

> 题目要求非零元的相对顺序不变，对于0来说没有什么相对顺序。因此，我们这样考虑，遍历数组，inserPos=0，遇到非零元素我们执行这样的操作：nums[insertPos++]=num,否则什么不做。最后检查insertPos与nums.length的大小填充0元素。

代码如下：

```java
public class Solution {
    public void moveZeroes(int[] nums) {
         if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
    }
}
```

# 2017-5-5

>Given a `pattern` and a string `str`, find if `str` follows the same pattern.
>
> Here **follow** means a full match, such that there is a bijection between a letter in `pattern` and a **non-empty** word in `str`.
>
>**Examples:**
>
>1. pattern = `"abba"`, str = `"dog cat cat dog"` should return true.
>2. pattern = `"abba"`, str = `"dog cat cat fish"` should return false.
>3. pattern = `"aaaa"`, str = `"dog cat cat dog"` should return false.
>4. pattern = `"abba"`, str = `"dog dog dog dog"` should return false.

代码如下：

```java
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
    }
}
//第二种方法
import java.util.Hashtable;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        int len = pattern.length();
        if(arr.length != len){
            return false;
        }
        Hashtable<Character, String> table = new Hashtable<Character, String>();
        for( int i = 0; i < len; i++){
            char c = pattern.charAt(i);
            if( table.containsKey(c) && !table.get(c).equals(arr[i])){
                return false;
            }
            else if( !table.containsKey(c) && table.contains(arr[i])){
                return false;
            }
            else{
                table.put(c, arr[i]);
            }
        }
        return true;
    }
}
```

## 范围求和

> 给顶一个整数数组nums,找到索引i和j（i<=j）之间的元素之和，其中包括i和j。注意：1.假定数组不变。2.对sumrange函数可以多次调用。

代码如下：

```java
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        if(nums.length != 0){
            sums = new int[nums.length];
        
            sums[0] = nums[0];
            for(int i=1; i<nums.length; i++){
                sums[i] = nums[i] + sums[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i==0 ? sums[j] : sums[j]-sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
```

