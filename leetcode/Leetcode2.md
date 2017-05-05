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

