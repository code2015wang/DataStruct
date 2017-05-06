

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

# 2017-5-6

## nim 游戏

> 你和你的朋友一起玩下面的nim游戏：在桌上有一堆石头，每次你们轮流去拿1到3块石头。拿到最后一块石头的人为胜利。每次开始时都是你拿石头。请实现一个函数来判断你是否能取胜。例如，如果由4块石头的话，你不可能赢，因为无论你拿几块石头，最后一定是你的朋友拿到最后一块。

> 根据题目提示，在玩游戏的时候，第一个获得4的倍数的数字将失败，否则他将获胜。
>
> 基本情况当n=4时，总是第二个玩家胜利。
>
> 当4<n<8 时，第一个玩家拿走相应的数，将4留给第二个玩家则第一个玩家胜利。
>
> 现在到写一个循环的开始，n=8,无论第一个玩家拿走多少，4总会留给自己。因此只要判断总数是否是4的倍数即可。

代码如下：

```java
public class Solution {
    public boolean canWinNim(int n) {
       return n % 4 != 0 ;
    }
}
```

## 3的幂

> 给定一个整数，写一个函数来确定是否为3的幂。你能解决这个问题不使用循环或递归吗？

代码如下：

```java
public class Solution {
    public boolean isPowerOfThree(int n) {
          // 1162261467 is 3^19,  3^20 is bigger than int  
    return ( n>0 &&  1162261467%n==0);
    }
}
```

```java
//递归的解法
public boolean isPowerOfThree(int n) {
    return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
}
```

```java
//循环的解法
public boolean isPowerOfThree(int n) {
    if(n>1)
        while(n%3==0) n /= 3;
    return n==1;
}
```

或者用数学公式来求解

```java
public boolean isPowerOfThree(int n) {
    return n==0 ? false : n==Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
}//注意这里需要取整。
```

## 2的幂

> 快速判断一个数是否为2的幂

> 将2的幂次方写成二进制形式后，很容易发现一个特点就是二进制中只有1个1,并且1后面的所有数为0,如果把这个数减1,你会发现只有那个1变成0,其余0变成1.这两数进行与运算你会发现为0.因此最快速的方法是
>
> (numbers& numbers-1)==0

## 4的幂

> 给定一个32位的整数，编写一个方法来测试它是否为4的幂

代码如下：

```java
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
```

基本思想是：我们从2的幂开始，我们使用“n&(n-1)==0”来确定n是否为2的幂。然而4的幂我们需要加以限制。我们发现4的幂的二进制形式，唯一的“1”应该总位于技术的位置。如4^0=1,4^1=0100,所以我们可以使用"num&0X55555555==num"来检查“1”是否位于奇数位置。（0X55555555是16进制，5的二进制表示是0101（奇数为1）&操作之后如果是4的倍数则数值不变）

## 字符串元音字母反转

> 字符串作为输入输出字符串的元音字母之间反转后的字符串。如hello输出反转e和o之间的字母后的字符串holle.leetcode输出转后的字符串为leotcede.

代码如下：

```java
public class Solution {
public String reverseVowels(String s) {
    if(s == null || s.length()==0) return s;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){
        
        while(start<end && !vowels.contains(chars[start]+"")){
            start++;
        }
        
        while(start<end && !vowels.contains(chars[end]+"")){
            end--;
        }
        
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        
        start++;
        end--;
    }
    return new String(chars);
}
}
```

> String 中的`contains(CharSequence s)`的参数为CharSequence ，因此代码中这样写：vowels.contains(chars[start]+"")。另外，String是java中的字符串，它继承CharSequence。CharSequence是一个接口。

