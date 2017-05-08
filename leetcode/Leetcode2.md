

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

# 2017-5-7

## 两个数组的交集

> 给定两个数组，编写一个函数计算两个数组的交集。

遍历数组，把交集存储在集合中，然后把集合转换成数组输出。

代码如下：

```java
import java.util.HashSet;
import java.util.Iterator;
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]) {
                    if(!set.contains(nums2[j])) set.add(nums2[j]);
                }
            }
        }
        int n=set.size();
        int[] result=new int[n];
        Iterator<Integer> iter=set.iterator();
        int i=0;
        while(iter.hasNext()){
            result[i]=iter.next();
            i++;
        }
        return result;
    }
}
```

同样的思路但是这样用空间复杂度代替实践复杂度

代码如下：

```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}
```

这个复杂度更低，先排序然后在处理。

代码如下：

```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}

```

## 数组交集II

> 给定两个数组，编写函数来计算他们到交集。交集中数字可以重复。如num1=[1,2,2,1],nums2=[2,2],返回[2,2].

思路同样，但这次我们使用list来存储中间结果。

代码如下：

```java
import java.util.ArrayList;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList temp=new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]) {
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
               temp.add(nums2[j]);
               i++;
               j++;
               
            }
        }
        int[] result=new int[temp.size()];
        for(int k=0;k<temp.size();k++){
            result[k]=(int)temp.get(k);
        }
        return result;
    }
}
```

## 验证平方

> 给定一个数字，编写一个函数判断该数是否为平方数。请不要使用任何的sqrt()内置函数。

我们发现任何一个等差数列的求和会是一个数的平方和。
$$
（1+3+5+7+......+(2n-1)）=n*(1+(2*n+1))/2=n^2
$$
所以代码如下：

```java
public class Solution {
    public boolean isPerfectSquare(int num) {
       /*  if (num < 1) return false;
      for (int i = 1; num > 0; i += 2)
        num -= i;
      return num == 0;*/
      if(num<1) return false;
      for(int i=1;num>0;i=i+2){
          num=num-i;
      }
      return num==0;
    }
}
```

## 计算两数和

> 计算两数的和但不允许使用+和-

代码如下：

```java
public class Solution {
    public int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }
}
```

位运算技巧：

1. 计算给定二进制中1的个数

代码如下：

```java
int count_one(int n){
  while(n){
    n=n&(n-1);//n&(n-1)不仅仅用于判断整数是否为2的幂
    count++;
  }
  return conut;
}
```

2. 是否是4的幂

代码如下：（先判断是否是2的幂在验证1是否位于特殊位置）

```java
bool isPowerOfFour(int n){
  return n>0&& n&(n-1)==0&& (n&0x55555555)!=0;
}
```

3. 两数求和

代码如下：

```java
int getSum(int a, int b) {
    return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
}
```

4. 找到丢失的数字

代码如下：

```java
int missingNumber(vector<int>& nums) {
    int ret = 0;
    for(int i = 0; i < nums.size(); ++i) {
        ret ^= i;
        ret ^= nums[i];
    }
    return ret^=nums.size();
}


```

5. 找到小于或等于给定数字的最大数字，并返回该数字的二进制形式。

代码如下：

```java
long largest_power(long N) {
    //changing all right side bits to 1.
    N = N | (N>>1);
    N = N | (N>>2);
    N = N | (N>>4);
    N = N | (N>>8);
    N = N | (N>>16);
    return (N+1)>>1;
}


```

6. 反转32位无符号整数的二进制位。

代码如下：

```java
uint32_t reverseBits(uint32_t n) {
    unsigned int mask = 1<<31, res = 0;
    for(int i = 0; i < 32; ++i) {
        if(n & 1) res |= mask;
        mask >>= 1;
        n >>= 1;
    }
    return res;
}
```

## 猜数游戏

> 你现在在玩一个猜数游戏。这个游戏的规则如下：从1到n选择一个数，你需要猜出选择的这个数是多少。每次你猜错，我将告诉你你猜的是大或小。现编写一个函数，你需要多次调用guess()函数，guess（）返回-1，猜小了。1猜大了。0猜中了。这道题我们使用二分查找法。

代码如下：

```java
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
       int low=1,high=n;
       while(low<high){
           int mid=low+(high-low)/2;
           if(guess(mid)==0) {
               return mid;
           }
           else if(guess(mid)==1){
               low=mid+1;
           }else{
               high=mid;
           }
       }
       return low;
    }
}
```

# 2017-5-8

## 赎金票据

> 给定任意的赎金票据字符串和另一个票据字符串，包含任意字母的字母仓库。编写一个函数，如果能从字母仓库，构建赎金票据字符串则返回true。否则，返回false。如
>
> ```
> canConstruct("a", "b") -> false
> canConstruct("aa", "ab") -> false
> canConstruct("aa", "aab") -> true
> ```

代码如下：

```java
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```

## 字符串第一个特殊的字符

> 给定一个字符串，找到第一个不重复的字符串返回它的序号。如果不存在，返回-1.

> 我们发现字符串中第一个不重复的字符的一个特点是它的indexOF和lastIndexOf一致。因此可以使用嗯这个来判断

代码如下：

```java
public class Solution {
    public int firstUniqChar(String s) {
       
		char[] a = s.toCharArray();
		
		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;
}
}
```

我们还可以使用另外一种方法，与上衣题的思路类似，用26个字母边生成临时数组，遍历字符串，对应字母计数。然后遍历临时数组，如果数组中哪个为1,就为要找的index。

代码如下：

```java
public class Solution {
    public int firstUniqChar(String s) {
       
	/*	char[] a = s.toCharArray();
		
		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;*/
		int[]  arr=new int[26];
		for(int i=0;i<s.length();i++){
		    arr[s.charAt(i)-'a']++;
		}
		for(int j=0;j<s.length();j++){
		    if(arr[s.charAt(j)-'a']==1) return j;//注意这里如何判断==1的，
          //注意这里是arr[s.charAt(j)-'a]==1而不是arr[j]==1
	
		}
		return -1;
}
}
```

## 找到不同

> 给定两个字符串s和t，他们仅包括小写字母。字符串t是由s随机生成并在任意位置加入一个字母。请找出t中增加加的字母。

我们还延续上一题的思路：遍历计数然后验证

代码如下：

```java
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i)-'a']++;
        }
        for(int j=-0;j<s.length();j++){
            arr[s.charAt(j)-'a']--;
        }
        for(int k=0;k<t.length();k++){
            if(arr[t.charAt(k)-'a']!=0) return t.charAt(k);
        }
        return 0;
    }
}
```

我们还有个思路：利用^ 操作，因为1^1=0来得到最后结果。

代码如下：

```java
public class Solution {
    public char findTheDifference(String s, String t) {

        char c = 0;
	for (int i = 0; i < s.length(); ++i) {
		c ^= s.charAt(i);
	}
	for (int i = 0; i < t.length(); ++i) {
		c ^= t.charAt(i);
	}
	return c;
    }
}
```

## 第n位字符串

> 将自然数序列看作一个长字符串，求第n位上的数字是多少？注意双位数是两个字符。

代码如下：

```java
public class Solution {
    public int findNthDigit(int n) {
        int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
```

