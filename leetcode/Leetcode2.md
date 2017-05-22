

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

# 2017-5-9

## 二进制手表

> 二进制表在顶部有4个LED，表示小时（0-11），底部的6个LED表示分钟(0-59).每个LED代表一个零或一个1.右边为最低有效位。给定一个非负整数n，表示当前开启状态的LED数量，返回手表可能代表的所有时间。注意：输出顺序无关紧要。小时不能包含前导0,例如“01：00”，应为“1：00”。分钟必须为两位数组成。例如“10：2”无效，要输出“10：02”。

我们这里先来看一种解法：这个解法利用了bitset这个类，可他以将任意进制的数转换为二进制，而且用到了count函数，用来统计1的个数。那么时针从0遍历到11,分针从0遍历到59,让那后我们把时针的数组左移6位加上分针的数值，然后统计1的个数，即维量等的个数，那麽，我们遍历所有情况，当其等于num的时候，存入res中。代码如下：

```java
/*这里代码似乎有误，BitSet不是这样用的，但上面的思路是正确的*/
class Solution {
public:
    vector<string> readBinaryWatch(int num) {
        vector<string> res;
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (bitset<10>((h << 6) + m).count() == num) {
                    res.push_back(to_string(h) + (m < 10 ? ":0" : ":") + to_string(m));
                }
            }
        }
        return res;
    }
};
```

下面同样的思路，但没有使用bitset类，代码如下：

```java
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
    for (int h=0; h<12; h++){
          for (int m=0; m<60; m++){
              if(Integer.bitCount(h)+Integer.bitCount(m)==num){
                  times.add(String.format("%d:%02d",h,m));
              }
          }
    }
      
            /*if (Integer.bitCount(h * 64 + m) == num)//左移6位+m转换成二进制数然后计算1的个数
                times.add(String.format("%d:%02d", h, m));*/
    return times;     
    }
}
```

Java.lang.Integer.bitcount(int i) 返回用二进制补码表示i的1的个数。

Java.lang.Integer.toBinaryString(int i) 把对应的整型数i转换成二进制（字符串）。

对应还有toHexString(int i) 转换成16进制。toOctalString(int i) 转换成8进制。

示例代码如下：

```java
package com.yiibai;

import java.lang.*;

public class IntegerDemo {

   public static void main(String[] args) {

     int i = 170;
     System.out.println("Number = " + i);
    
     /* returns the string representation of the unsigned integer value 
     represented by the argument in binary (base 2) */
     System.out.println("Binary = " + Integer.toBinaryString(i));

     // returns the number of one-bits 
     System.out.println("Number of one bits = " + Integer.bitCount(i)); 
   }
} 
```

int numberOfLeadingZeros(int i) 给定一个int类型数据，返回这个数据的二进制串中从最左边算起连续的“0”的总数量。因为int类型的数据长度为32所以高位不足的地方会以“0”填充。

nt numberOfTrailingZeros(int i) 给定一个int类型数据，返回这个数据的二进制串中从最右边算起连续的“0”的总数量。因为int类型的数据长度为32所以高位不足的地方会以“0”填充

Integer decode(String nm) 给定一个10进制，8进制，16进制中任何一种进制的字符串，该方法可以将传入的字符串转化为10进制数字的Integer类型并返回。

+ java Bitset类

一个Bitset类创建一种特殊leiixng的数组来保存位值。Bitset中数组大小会随着需求增加。这和位向量比较类似。BitSet示例：

```java
import java.util.BitSet;

public class BitSetDemo {

  public static void main(String args[]) {
     BitSet bits1 = new BitSet(16);
     BitSet bits2 = new BitSet(16);
      
     // set some bits
     for(int i=0; i<16; i++) {
        if((i%2) == 0) bits1.set(i);
        if((i%5) != 0) bits2.set(i);
     }
     System.out.println("Initial pattern in bits1: ");
     System.out.println(bits1);
     System.out.println("\nInitial pattern in bits2: ");
     System.out.println(bits2);

     // AND bits
     bits2.and(bits1);
     System.out.println("\nbits2 AND bits1: ");
     System.out.println(bits2);

     // OR bits
     bits2.or(bits1);
     System.out.println("\nbits2 OR bits1: ");
     System.out.println(bits2);

     // XOR bits
     bits2.xor(bits1);
     System.out.println("\nbits2 XOR bits1: ");
     System.out.println(bits2);
  }
}
```

输出:

```java
Initial pattern in bits1:
{0, 2, 4, 6, 8, 10, 12, 14}

Initial pattern in bits2:
{1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14}

bits2 AND bits1:
{2, 4, 6, 8, 12, 14}

bits2 OR bits1:
{0, 2, 4, 6, 8, 10, 12, 14}

bits2 XOR bits1:
{}
```

BitSet可以用来存储海量数据：

[Java](http://lib.csdn.net/base/javase).util.BitSet可以按位存储。
计算机中一个字节（byte）占8位（bit），我们java中数据至少按字节存储的，
比如一个int占4个字节。
如果遇到大的数据量，这样必然会需要很大存储空间和内存。
如何减少数据占用存储空间和内存可以用[算法](http://lib.csdn.net/base/datastructure)解决。
java.util.BitSet就提供了这样的算法。
比如有一堆数字，需要存储，source=[3,5,6,9]
用int就需要4*4个字节。
java.util.BitSet可以存true/false。
如果用java.util.BitSet，则会少很多，其原理是：
1，先找出数据中最大值maxvalue=9
2，声明一个BitSet bs,它的size是maxvalue+1=10
3，遍历数据source，bs[source[i]]设置成true.
最后的值是：
(0为false;1为true)
bs [0,0,0,1,0,1,1,0,0,1]
                3,   5,6,       9

这样一个本来要int型需要占4字节共32位的数字现在只用了1位！
比例32:1  
这样就省下了很大空间。

+  java中BitSet

java中BitSet就是位图数据结构，根据位图的语义，数据的存在性可以使用bit位上1或0来表示，一个bit具有2个值：0和1,正好可以用来表示true和false。对于判断“数据是否存在”的场景，我们通常使用hashmap来存储，不过hashmap这个数据结构需要消耗较多的内存，不适合保存较多的数据，即大叔据场景。比如在10亿条URl记录中判定一个“www.baidu.com/a”是否存在。如果我们使用bitset来保存，那麽可以对一条url求hashcode，并将数字映射到bitset上，那麽事实上它h只需要一个bitset即可，即我们1位空间即可表达一个URl字符串的存在性。

    1) BitSet只面向数字比较，比如set(int a,boolean value)方法，将数字a在bitSet中设定为true或者false；此后可以通过get(int a)方法检测结果。对于string类型的数据，如果像使用BitSet，那么可以将其hashcode值映射在bitset中。

    2) 首先我们需要知道：1，1<<64，1<<128，1<<192...等，这些数字的计算结果是相等的（位运算）；这也是一个long数字，只能表达连续的(或者无冲突的)64个数字的状态，即如果把数字1在long中用位表示，那么数字64将无法通过同一个long数字中位表示--冲突；BitSet内部，是一个long[]数组，数组的大小由bitSet接收的最大数字决定，这个数组将数字分段表示[0,63],[64,127],[128,191]...。即long[0]用来存储[0,63]这个范围的数字的“存在性”，long[1]用来存储[64,127]，依次轮推，这样就避免了位运算导致的冲突。

   3）bitSet内部的long[]数组是基于向量的，即随着set的最大数字而动态扩展。数组的最大长度计算：

```
(maxValue - 1) >> 6  + 1  
```

   4）使用bitset做字符串的存在性检验

```java
    BitSet bitSet = new BitSet(Integer.MAX_VALUE);//hashcode的值域  
      
    //0x7FFFFFFF  
    String url = "http://baidu.com/a";  
    int hashcode = url.hashCode() & 0x7FFFFFFF;  
    bitSet.set(hashcode);  
      
    System.out.println(bitSet.cardinality());//着色位的个数  
    System.out.println(bitSet.get(hashcode));//检测存在性  
    bitSet.clear(hashcode);//清除位数据  
```

   5）BloomFilter（布隆姆过滤器）

 BloomFilter 的设计思想和BitSet有较大的相似性，目的也一致，它的核心思想也是使用多个Hash算法在一个“位图”结构上着色，最终提高“存在性”判断的效率。请参见Guava  BloomFilter。如下为代码样例：

```java
    Charset charset = Charset.forName("utf-8");  
    BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(charset),2<<21);//指定bloomFilter的容量  
    String url = "www.baidu.com/a";  
    bloomFilter.put(url);  
    System.out.println(bloomFilter.mightContain(url));  
```

 一道题：1千万个随机数，随机数的范围在1到1亿直接按，现在要求写出一道算法，将1到1亿没有出现在随机数里的数据找出来？

代码如下：

```java

public class Alibaba
{
    public static void main(String[] args)
    {
        Random random=new Random();
        
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10000000;i++)
        {
            int randomResult=random.nextInt(100000000);
            list.add(randomResult);
        }
        System.out.println("产生的随机数有");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        BitSet bitSet=new BitSet(100000000);
        for(int i=0;i<10000000;i++)
        {
            bitSet.set(list.get(i));
        }
        
        System.out.println("0~1亿不在上述随机数中有"+bitSet.size());
        for (int i = 0; i < 100000000; i++)
        {
            if(!bitSet.get(i))
            {
                System.out.println(i);
            }
        }     
    }
}
```

## 布隆过滤器

布隆过滤器的作用是加速判断一个元素是否在集合中出现的方法。因为其主要过滤了大部分元素间的精确匹配，故称过滤器。其应用场景为需要频繁在一个海量的集合中查找某个元素是否存在。

例如：

假设有一些字符串，假设有一个字符串a，要在集合B中查找其是否在集合B中。最笨的方法是遍历集合B中的每个元素bi，精确匹配a是否等于bi。若集合B中有N个元素，则最坏情况下需要执行N次精确匹配。

一个改进的方法是将a和B中每个字符串按照特定规则映射为数字，**称为hash值**。规则可以任意设置。比如取各字符串的首字母和尾字母的编码之乘积，取奇数个字符的编码执行异或，等。将比较字符串问题变成一个比较数字的问题。比较字符串需要从头到尾比较，而数字的比较会快很多。

需要注意的是，当两个字符串相同时，采用相同的映射规则得到的数字一定相同。但当两个字符串不同时，得到的字符串不一定不同。所以，当我们发现两个字符串的**hash值**相同时，两个字符串不一定相同，所以需要进一步去精确匹配两个字符串是否相同。但采用hash值方法已经能够过滤掉一部分以前需要精确匹配的计算量。仅当hash值相同（假设hash值通过字符串首尾字母计算得来，则当两个字符串首尾字母相同时hash值相同）时才去比较字符串本身。若选择hash值合理，则性能将大幅提高。

布隆过滤器通过将一个字符串使用多个不同的hash值计算方法，映射为多个不同的hash值，当所有这些hash值完全相同时，才认为两个字符串相同。从而进一步降低了放生hash值相同的可能性，从而进一步提高了过滤的性能。

布隆过滤器是由巴顿*布隆于1970年提出的。它实际上是一个很长的二进制向量和一系列随机映射函数。我们通过上面的例子来说明起工作原理。

假定我们存储一亿个电子邮件地址，我们先建立一个十六亿二进制（比特），即两亿字节的向量，然后将这十六亿个二进制全部设置为零。对于每一个电子邮件地址
 X，我们用八个不同的随机数产生器（F1,F2, ...,F8） 产生八个信息指纹（f1, f2, ..., f8）。再用一个随机数产生器 G 
把这八个信息指纹映射到 1 到十六亿中的八个自然数 g1, g2, ...,g8。现在我们把这八个位置的二进制全部设置为一。当我们对这一亿个 
email 地址都进行这样的处理后。一个针对这些 email 地址的布隆过滤器就建成了

代码如下：

```java
/*布隆过滤器（Bloom Filter）是1970年由Burton Howard Bloom提出的。
*它实际上是一个很长的二进制向量和一系列随机映射函数。
*布隆过滤器可以用于检索一个元素是否在一个集合中。
*它的优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。
*/

import java.util.BitSet;

public class SimpleBloomFilter { 

      private static final int DEFAULT_SIZE = 2 << 64;
      private static final int[] seeds = new int[] { 7, 113, 213, 3111, 397, 611,532 };  //不同的函数seed
      private BitSet bits = new BitSet(DEFAULT_SIZE);

      private SimpleHash[] func = new SimpleHash[seeds.length];   //func 函数数组
       
      public SimpleBloomFilter() {
          for (int i = 0; i < seeds.length; i++) func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);   //初始化func函数数组
      } 

       public static class SimpleHash { 
           
     	  private int cap; 
          private int seed;
          public SimpleHash(int cap, int seed) { 
               this.cap = cap;
               this.seed = seed;  
           } 

	       public int hash(String value) {
	            int result = 0;
	            int len = value.length(); 
	           for (int i = 0; i < len; i++)result = seed * result + value.charAt(i); //一般的hash算法
	           return (cap - 1) & result;   //把值的范围控制在cap内
	       }
       } 
       
      
      public void add(String url) {    //bloom filter 添加url值
          for (SimpleHash f : func)bits.set(f.hash(url), true); 
     }      

      public boolean contains(String value) {   //判断 bloom filter 是否包含url值
         if (value == null) {return false;}
         boolean ret = true; 
         for (SimpleHash f : func)ret = ret && bits.get(f.hash(value));
         return ret;
       }
       
      
       public static void main(String[] args) { 
           String[] urls = new String[]{"www.example.com","www.renren.com","www.baidu.com","www.baidu.com"};  //测试数据
           SimpleBloomFilter filter = new SimpleBloomFilter(); 
           for(String value : urls){
        	   value = value.trim();
	           System.out.println("filter.contains("+value+"):"+filter.contains(value));
	           filter.add(value); 
	           System.out.println("filter.add("+value+"):"+filter.contains(value));
	           System.out.println("----------------------------------------------------");
	        }
       }
       
} 
```

bitset的一个例子

```java
package test;
import java.util.BitSet;
public class WhichChars {
   private BitSet used = new BitSet();
   public WhichChars(String str){
      for(int i=0;i< str.length();i++)
        used.set(str.charAt(i));  // set bit for char
   }
    public String toString(){
         String desc="[";
         int size=used.size();
         System.out.println("size:"+size);
          for(int i=0;i< size;i++){
        	
             if(used.get(i)){
            	 
            
            	 
                 desc+=(char)i;
            
             }
            }
             return desc+"]";
         }
    public static void main(String args[]){
        WhichChars w=new WhichChars("How do you do");
        System.out.println(w);
    }
   }
```

## 左子树之和

> 找到一个二叉树的所有左子树之和

代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
    int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) ans += root.left.val;
        else ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
        
    }
}
```

# 2017-5-10

## 整数转换为16进制

> 编写一个函数实现，把一个整数转换为16进制的数，负整数使用二进制的补码。

代码如下：

```java
public class Solution {
    public String toHex(int num) {
        return Integer.toHexString(num);
    }
}
```

另外一种方法：

```java
/*
Basic idea: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.
            
            每次我们看看最后四位数字
             二进制verion的输入，并将其映射到十六进制字符
             将输入向右移动4位，再次执行
             直到输入变为0。

*/

public class Solution {
    
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
    
    
}
```

## 最长回文

> 给定一个由小写或大写字母组成的字符串，找到可以用这些字母构建的最长的回文长度。

我们这里可以利用hashset的特性（没有重复元素），遍历字符串，依次存入hashset。如果集合中已存在则计数加一，同时把元素从集合中移除，否则加入集合。最后判断集合是否为空，如果为空则最长为计数的2倍;否则为计数的2倍加1.注意这里集合不为空的话，集合中不一定只有一个元素，所以不能用集合的size来计算最长回文长度。这里只能使用我们自己的计数来计算。

代码如下：

```java
import java.util.HashSet;
public class Solution {
    public int longestPalindrome(String s) {
        if(s==null||s.length()==0) return 0;
        int conut=0;
        HashSet set=new HashSet<String>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                conut++;
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
            
        }
        if(!set.isEmpty()) return 2*conut+1;
        return 2*conut;
    }
}
```

## Fizz  Buzz

> 编写一个程序，输出数字的字符串表示从1到n。但对于3的倍数，它因该输出Fizz而不是数字;对于5的倍数输出Buzz。对于是3和5的倍数输出FizzBuzz。

代码如下：

```java
import java.util.ArrayList;
public class Solution {
    public List<String> fizzBuzz(int n) {
        List result=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5!=0) result.add("Fizz");
            else if(i%5==0&&i%3!=0) result.add("Buzz");
            else if(i%3==0&&i%5==0) result.add("FizzBuzz");
            else result.add(Integer.toString(i));
        }
        return result;
    }
}
```

## 第三大数

> 给定一个整型数组，返回第三大的数字，如果该数字不存在，则返回最大梳子。要求时间复杂度为o(n).

java优先队列中元素可以默认自然排序或者通过提供的Comparator在队列实例化时排序。优先队列的头是基于自然排序或comparator排序的最小元素。我们如果使用优先队列的话，只需要把队列的第三个元素输出即可。另外这里还有点技巧的处理（由于最大和第三大元素有用，因此我们需要对队列进行处理，根据size的大小使用poll依次从队首删除元素，只保留有用元素），具体代码：

代码如下：

```java
public class Solution {
    public int thirdMax(int[] nums) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();//优先队列
        Set<Integer> set = new HashSet<>();//set过滤重复元素
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());//pq.roll()从队首开始依次删除元素
                }//保证优先队列永远只有最大的三个，且第三大在队首
              //注意这里，我们必须要在这里进行>3的判断，因为如果存在多个元素一样的话，可能第三大
              //的元素就是该元素，因此需要在pq和set中都做处理，之后才能决定是否在set中添加元素。
              //我们不能在都加入pq之后做>3的处理，这样会得到求解不正确的结果。
            }
        }
        if (pq.size() < 3) {//如果不存在第三大元素
            while (pq.size() > 1) {
                pq.poll();//pq中只剩最大的一个
            }
        }
        return pq.peek();//返回队首元素
    }
}

  /* int len=nums.length;
        Arrays.Sort(nums);
        if(nums.length>3) return nums[len-3];
        return nums[len];
        //不能使用这个因为有多个元素是一样的话，这样写得不到正确的结果。这也是为什么要使用set
        //的原因。
        */
```

# 2017-5-11

## 字符串相加

> 给定两个非负的整数num1和num2把他们看作字符串，返回num1+num2。注意：
>
> 1. num1和num2的长度都是<5100
> 2. num1和num2都只包含数字0-9
> 3. num1和num2都不包含任何前导零
> 4. 不得使用任何内置的BigInteger库或直接将输入转换为整数

这道题是用字符串来实现十进制加法，和前面用字符串实现二进制加法类似，代码如下：

```java
public class Solution {
    public String addStrings(String num1, String num2) {
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        StringBuilder sb=new StringBuilder();
        int sum=0,carry=0;
        while(len1>=0||len2>=0){//注意有等号
            int first=len1>=0?num1.charAt(len1)-'0':0;//注意有等号
            int sencond=len2>=0?num2.charAt(len2)-'0':0;
            sum=carry+first+sencond;
            if(sum<=9){
                sb.insert(0,sum);
                sum=0;
                carry=0;
            }else{
                sb.insert(0,sum%10);
                sum=0;
                carry=1;
            }
            len1--;
            len2--;
        }
        if(carry==1) sb.insert(0,"1");
        return sb.toString();
    }
}//注意这道题的逻辑思路
```

## 字符串中段数

> 计算字符串中的段数，其段数的定义为非空格字符的连续序列。注意，字符串不包含任何不可打印的字符。

这道题我们很容易想到使用split函数，但需要做点预处理及使用合适的正则表达式

代码如下：

```java
public class Solution {
    public int countSegments(String s) {
      String trimmed = s.trim();
    if (trimmed.length() == 0) return 0;
    else return trimmed.split("\\s+").length;

    }
}
```

正则表达式中 ”\\\s“ 表示空格 ，回车，换行等空白符  +号表示一个或多个的意思。

## 路径和

> 给定一个二叉树，该二叉树每个节点都是整型数。给定一个整数，找到所有的路径。这个路径不需要从根节点开始，但必须是从父节点到子节点。该树有不多于1000个节点，节点数值范围为-1000000到1000000.

关于这个问题，我们可以分三种情况来考虑：1.从根节点来寻找 2.从根节点的左子树来寻找 3. 从根节点的右子树来寻找。在寻找的是时候使用递归方法，我们可以定义寻找方法为pathSumFrom。代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        
    if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);//分别从根节点，根节点左子树，根节点右子树来寻找
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
            /*在寻找方法里，递归调用。pathSum调用 pathSumFrom。pathSumFrom调用自身。如果node.val==sum即找到一条路径*/
    }
}
```

## 查找字符串中所有匹配（顺序可以不一样）

> 给定一个字符串s和一个非空字符串p，在s中找到所有p开始的索引。字符串仅由小写英文字母组成，字符串s和p的长度不得大于20100.例如：
>
> ```
> Input:
> s: "cbaebabacd" p: "abc"
>
> Output:
> [0, 6]
>
> Explanation:
> The substring with start index = 0 is "cba", which is an anagram of "abc".
> The substring with start index = 6 is "bac", which is an anagram of "abc".
> ```
>
> ```
> Input:
> s: "abab" p: "ab"
>
> Output:
> [0, 1, 2]
>
> Explanation:
> The substring with start index = 0 is "ab", which is an anagram of "ab".
> The substring with start index = 1 is "ba", which is an anagram of "ab".
> The substring with start index = 2 is "ab", which is an anagram of "ab".
> ```

代码如下：

```java
import java.util.ArrayList;
public class Solution {
    public   List<Integer> findAnagrams(String s, String p) {
      ArrayList<Integer> result=new ArrayList();
	        if(s==null||s.length()==0||p==null||p.length()==0) return result;
	        int[] hash=new int[256];
	        for(char c :p.toCharArray()){
	            hash[c]++;//将p中字符集其个数做统计
	        }
	        int right=0,left=0,count=p.length();
	        while(right<s.length()){//遍历s，同时对hash数组进行处理，
	        if(hash[s.charAt(right++)]-->=1) count--;//s中的字符在p中出现
	        /*上面一句话和下面等效
	        
	         if(hash[s.charAt(right)]>=1){
	        	count--;//s中的字符在p中出现
	        	hash[s.charAt(right)]--;
	        	right++;
	        	//hash[s.charAt(right)]--;
	        }
	        */
	        if(count==0) result.add(left);
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;  
              //注意这句，很重要
	        }
	        return result;
}
}
```

# 2017-5-14

## 排硬币

> 你有n个硬币，你想给它排成一个梯形，满足在k行有k个。给定非负整数n，编写函数返回满足条件的k。
>
> 如n=5,5=1+2+2,最后一行只排2个不满足条件因此函数将返回2.

> 问题相当于求解$$ n=(x+1)x/2 $$   ,根据公式法求解 ：$$ x_1 = \frac{-b+\sqrt{b^2-4ac}}{2a} $$  $$ x_2=-\frac{-b-\sqrt{b^2-4ac}}{2a} $$ 
>
> 在求解方程中 a=1 b=1 c=-2n，可以看到 $$ x= \frac{-1+\sqrt{1-8n}}{2} $$ 
>
> 所以代码如下：

```java
public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}
```

# 2017-5-16

##  元组数量

> 给定平面上的n个点都是成对不同的。我们需要找到的元组是（i，j，k）使i与k，i与j之间的距离相等。编写函数实现返回符合条件元组的个数。

代码如下：

```java
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
     if(points.length==0 || points[0].length==0) return 0;
        int ret = 0;
        for(int i=0;i<points.length;i++){
            Map<Integer, Set<int[]>> map = new HashMap<>();
            int[] p = points[i];
            for(int j=0;j<points.length;j++){
                if(j==i) continue;
                int[] q = points[j];
                int dis = getDis(p, q);
                if(!map.containsKey(dis)) map.put(dis, new HashSet<int[]>());
                map.get(dis).add(q);
            }
            for(Integer key : map.keySet()){
                int size = map.get(key).size();
                if(size>=2) ret += (size*(size-1));
            }
        }
        return ret;
    }
    public int getDis(int[] p, int[] q){
        int a = p[0]-q[0];
        int b = p[1]-q[1];
        return a*a+b*b;
    }
}
```

## 找出数组中消失的数字

> 给定一个整数数组，其中1<=a[i]<=n,(n=数组大小)，某些元素出现两次，而其他元素出现一次。找到不出现在在这个数组的中的[1,n]包含的所有元素。

这个我们使用BItSet来解决这个问题，代码如下：

```java
import java.util.BitSet;
import java.util.ArrayList;
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        BitSet set=new BitSet(nums.length);
        ArrayList list=new ArrayList();  
        for(int i:nums){
            set.set(i);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.get(i)){
                list.add(i);
            }
        }
        return list;
    }
}
```

## 使数组元素相等的最小移动数

> 给定大小为n的非空整数数组，中哦到所有使数组元素相等所需的最小移动数。

代码如下：

```java
public class Solution {
    public int minMoves(int[] nums) {
         if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}
```

## 分配蛋糕

> 假定你是一个非常好的父母，你需要给你的孩子分配饼干并且每个孩子至少要分配一个饼干。每个孩子心里有个贪心指数$$ g_i $$，这是他对饼干的最低要求，你必须要满足这个条件。饼干j有个尺寸$$ s_j $$ ,如果$$ s_j >= g_j  $$ 
>
> 那麽我们可以给孩子分配这个饼干。

代码如下：

```java
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
Arrays.sort(s);
int i = 0;
for(int j=0;i<g.length && j<s.length;j++) {
	if(g[i]<=s[j]) i++;
}
return i; 
    }
}
```

## 重复子串

> 给定一个非空字符串，检查它是否可以通过获取一个子字符串并将子字符串的多个副本附加在一起构造。假定给定的字符串仅由小写的英文字母组成，其长度不会超过10000.

代码如下：

```java
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
	for(int i=l/2;i>=1;i--) {
		if(l%i==0) {
			int m = l/i;
			String subS = s.substring(0,i);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++) {
				sb.append(subS);
			}
			if(sb.toString().equals(s)) return true;
		}
	}
	return false;
}
}
```

# 2017-5-17

## 汉明距离

> 汉明距离是把两个整数转换成二进制数，把位数不同称为汉明距离。给定x和y，编写函数求出汉明距离。
>
> 例如：x=1,由、=4,输出2.因为 1的二进制表示为0001,4的二进制表示为0100,不同位数为2.所以输出2.

这里我们明显看到汉明距离是x与y异或后1的个数。我们想到了Integer.bitCount（）。代码如下：

```java
public class Solution {
    public int hammingDistance(int x, int y) {
     return Integer.bitCount(x ^ y);
    }
}
```

另一种方法如下（做异或操作，然后移位计数）：

```java
public int hammingDistance(int x, int y) {
    int xor = x ^ y, count = 0;
    for (int i=0;i<32;i++) count += (xor >> i) & 1;
    return count;
}

```

## 岛周长

> 给出一个二维整数网格形式的地图，其中1表示土地，0表示水。网格单元水平/垂直（不对角线）连接。网格完全被水包围并且正好有一个岛（即一个或多个连接的地面），岛内没有水，一个单元格是具有边长为1的正方形。网格为矩形，宽度和长度不超过100，确定岛的周长。

这道题，我们需要发现的一个现象是如果有邻居的话，island*4-neighbour×2。因此，我们需要对岛屿进行计数，需要对岛屿的邻居进行计数。需要这两个变量。最后通过公式岛屿数乘以4-邻居数乘以2

代码如下：

```java
public class Solution {
    public int islandPerimeter(int[][] grid) {
         int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                  //同时需要注意计数规则，不能计数计重复了。只计下方和右方的即可。
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
```

## 加热器

> 冬天就要来了。你的第一份工作是设计一个标准的加热器加热整个房间。现在你能得到房间的位置和加热器的位置，找出加热器的最小半径。注意：
>
> 1. 房子和加热器的数量是非负数，不超过25000
> 2. 房屋和加热器的位置是肺腑数，不超过10^9
> 3. 只要房子处于加热器的半径范围内们就可以加热。
> 4. 所有加热器都遵循半径标准，半径内温度相同。

我们这道题的思路如下：

1. 对于每个房子，找到他们在这些加热1器之间的距离（需要对加热器进行排序）
2. 计算房子和左边加热器和右边加热器的距离，得到最小值。注意拐角处没有左加热器或右加热器
3. 获取步骤2中的最大值即为结果。

代码如下：

```java
import java.util.Arrays;
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result=Integer.MIN_VALUE;
        for (int house: houses){
            int index=Arrays.binarySearch(heaters,house);
            if(index<0){//没找到房子在加热器的两端
                index=-(index+1);
                
            }
            //判断房子与左、右加热器的距离
            int left= index-1>=0? house-heaters[index-1]:Integer.MAX_VALUE;
            int right =index<heaters.length ? heaters[index]-house: Integer.MAX_VALUE;
            result=Math.max(result,Math.min(right,left));
        }
        return result;
      
    }
}
```

## 数字补码

> 给定一个数字，输出其二进制补码表示的十进制数，这里的补码策略为反转二进制位。如输入5,其二进制为101,补码为010,故输出2.

Integer.hightestOneBit:   [返回整数的最高位（最左边）的位为1表示的整数],如170的二进制数表示为10101010.那麽Integer.highestOneBit(170)=128.

负数的补码的求解是取反末尾加1，整数补码是其本身。

代码如下：

```java
public class Solution {
    public int findComplement(int num) {
         int mask = (Integer.highestOneBit(num) << 1) - 1;//获得全1的掩码
        num = ~num;//取非操作
        return num & mask;//返回补码，计算补码据可以这样来算，不论正数或负数
    }
}
```

## 最长连续1的个数

> 给定二进制数，找到此数组中连续1的最大数。

代码如下：

```java
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) {
                count++;
                result=Math.max(count,result);
            }else{
                count=0;
            }
        }
        return result;
    }
}
```

## 构造矩形

> 对于web开发者来说，设计一个web页面是很重要的。所以，给定一个特定的矩形网页区域，现在你的工作就是设计一个矩形区域满足以下条件：
>
> 1. 设计的矩形面积必须等给定的目标区域。
> 2. L>=w
> 3. 长度L和宽度W之间的差异尽可能小

第一感觉是开平方，但我们需要在开平方之后继续处理，注意这点

```java
public class Solution {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
	while (area%w!=0) w--;
	return new int[]{area/w, w};
    }
}
```

## 下一个更大的数

> 给定两个数组nums1和num2,其中nums1是nums2的子集。查找nums2的相应位置中nums1元素的所有下一个更大的数字。
>
> ```
> Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
> Output: [-1,3,-1]
> Explanation:
>     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
>     For number 1 in the first array, the next greater number for it in the second array is 3.
>     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
> ```

代码如下：

```java
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ret = new int[findNums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) map.put(nums[i], -1);
            else map.put(nums[i], stack.peek());
            stack.push(nums[i]);
        }
        for(int i = 0; i < findNums.length; i++) {
            ret[i] = map.get(findNums[i]);
        }
        return ret;
    }
}
```

# 2017-5-18

##  寻找二叉搜索树的重复元素

> 给定具有重复的二叉搜索树（BST），找出给定BST中所有重复元素。BST定义如下：
>
> 1. 节点的左子树仅包括具有小于或等于该节点的密钥的几点
> 2. 节点的右子树仅包含大于或恩关于该节点的密钥的节点
> 3. 左右子树也必须是二叉搜索树。
>
> Given BST `[1,null,2,2]`,
>
> ```
>    1
>     \
>      2
>     /
>    2
>
> ```
>
> return `[2]`.

代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   
     Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}


```

## 转换7进制

> 给定一个整数，把它转换为7进制表示的字符串

代码如下：

```java
public class Solution {
    public String convertToBase7(int num) {
       if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        
        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }//注意这里的核心代码
        
        if (negative) {
            sb.append("-");
        }
        
        return sb.reverse().toString();//注意返回值，要先取反
    }
}
```

## 相对排名

> 给定n个运动员的分数，找到相对排名前三的运动员，分别授予 gold media , silver medal ,bronze medal .例如：
>
> ```
> Input: [5, 4, 3, 2, 1]
> Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
> Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
> For the left two athletes, you just need to output their relative ranks according to their scores.
> ```

代码如下：

```java
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }
}
```

## 完美数字

> 我们定义一个完美数字，它的所有约数之和等于其本身。编写函数，判断是否是完美数字。是返回true。否则返回false。

```java
public class Solution {
    public boolean checkPerfectNumber(int num) {
          if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        sum++;
        
        return sum == num;
    }
}
```

## 大写检测

> 给定一个单词，你需要判断大写使用的是否正确。我们定义大写字母使用规则如下：
>
> 1. 所有单词都大写
> 2. 所有单词都小写
> 3. 只有第一个字母大写

这里如果我们使用正则表达式:

```
[A-Z]+|[a-z]+|[A-Z][a-z]+
```

代码如下：

```java
public class Solution {
    public boolean detectCapitalUse(String word) {
       return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+"); 
    }
}
```

另一种想法，代码如下：

```java
public class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }
}
```

大写字母的ASCII范围为65---90;小写字母的ASCII范围为97-122.所以cnt=0时，全部为小写 cnt==word.length(),则全部为大写。后一种情况为首字母大写其余小写

##  Longest Uncommon Subsequence

> Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be **any** subsequence of the other strings.
>
> A **subsequence** is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
>
> The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

代码如下：

```java
public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
```

# 2017-5-22

## BST最小绝对差

> 给定具有非负值的二叉搜索树，找到任何两个节点的最小差值

代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
     int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }

}
```

## 反转字符串

> 给定一个字符串和一个整数k。以2k为单位，反转前k个。如果字符串长度不足k个反转全部。如果字符串小于2k大于k，反转k个字符，剩余的保持原样。

代码如下：

```java
public class Solution {
    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        for (int left = 0; left < ca.length; left += 2 * k) {
            for (int i = left, j = Math.min(left + k - 1, ca.length - 1); i < j; i++, j--) {
                char tmp = ca[i];
                ca[i] = ca[j];
                ca[j] = tmp;
            }
        }
        return new String(ca);
    }
}
```

## 二叉树直径

> 给定一个二叉树，你需要计算出二叉树的直径。二叉树的直径是这样定义的：任意两个节点之间路径的最长长度。这个路径可以通过也可以不通过根节点。

代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
```

## 学生考勤记录

> 你现在有一个字符串来代表学生的考勤记录。这个记录只包括以下字符：
>
> 1. ‘A'： absent  缺勤
> 2. ’L'： later 迟到
> 3. ‘P'： present  出席
>
> 一个学生出勤记录中如果有不多于1个的A或少于连续2个L。他应当被奖励。请编写函数确定学生是否应该被奖励。

这里给出一个字符串匹配的方法：

```java
public class Solution {
    public boolean checkRecord(String s) {
         return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
```

下面这种方法是很常规的计算字符串中有多少个A多少个L。但要注意连续的L才算数，看程序中如何计数连续的L

```java
public class Solution {
    public boolean checkRecord(String s) {
        olean checkRecord(String s) {
        int countA=0;
        int continuosL = 0;
        int charA = 'A';
        int charL ='L';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == charA){
                countA++;
                continuosL = 0;
            }
            else if(s.charAt(i) == charL){
                continuosL++;
            }
            else{
                continuosL = 0;
            }
            if(countA >1 || continuosL > 2 ){
                return false;
            }
        }
        return true;
    }
}
```

## 反转字符串中单词

> 给定一个字符串，你需要颠倒字符串中每个单词的顺序，同时仍保留空格和初始单词顺序。

```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```

代码如下：

```java
public class Solution {
    public String reverseWords(String s) {
   char[] s1 = s.toCharArray();
    int i = 0;
    for(int j = 0; j < s1.length; j++)
    {
        if(s1[j] == ' ')
        {
            reverse(s1, i, j - 1);
            i = j + 1;
        }
    }
    reverse(s1, i, s1.length - 1);//反转最后一个单词
    return new String(s1);
}

public void reverse(char[] s, int l, int r)
{
	while(l < r)
	{
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
		l++; r--;
	}
}
}
```

我们这里没有使用stingbuilder的reverse函数，因为需要保持原字符串中的空格和初始单词顺序，因此我们不能使用stingbuilder。因为stringbuilder有reserve函数，但无法知道其他信息如空格和逗号等，并且string没有insert函数。因此不能使用stringbuilder只能自己实现反转函数。

## 数组划分

> Given an array of **2n** integers, your task is to group these integers into **n** pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

代码如下：

```java
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
```

## 二叉树倾斜

> 给定一个二叉树，返回这个二叉树的倾斜。二叉树的倾斜定义为所有左子树之和与所有右子树之和差值的绝对值。

```
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
```

代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int result = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        result += Math.abs(left - right);
        
        return left + right + root.val;//这里返回时问什么要+root.val?
    }
}
```

## 变形矩阵

> 给出一个由二维数组表示的矩阵，两个正整数r和c分别表示所需要重组的矩阵的行号和列号。如果给定参数重塑操作是合法的，则返回重塑的矩阵，否则返回原矩阵。

代码如下：

```java
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
            int n = nums.length, m = nums[0].length;
    if (r*c != n*m) return nums;
    int[][] res = new int[r][c];
    for (int i=0;i<r*c;i++) 
        res[i/c][i%c] = nums[i/m][i%m];
    return res;
    }
}
```

## 判断子树

> 给定两个非空的二叉树s和t，检查s是否是t的子树。s子树可以认为是s的节点及其后代节点组成的，树可以看作是本身的子树。

代码如下：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
```

## 分配糖果

> 给定一个具有均匀长度的整数数组，该数组中的不同数字表示不同种类的糖果。 每个数字表示相应类型的一个糖果。 你需要将这些糖果数量分配给兄弟姐妹。 返回姐妹可以获得的最多种类的糖果。

代码如下：

```java
public class Solution {
    public int distributeCandies(int[] candies) {
          Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}
```

