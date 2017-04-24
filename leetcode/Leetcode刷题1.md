# 2017-4-11

## two_sum

> Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.
>
> You may assume that each input would have **exactly** one solution, and you may not use the *same* element twice.
>
> **Example:**
>
> ```
> Given nums = [2, 7, 11, 15], target = 9,
>
> Because nums[0] + nums[1] = 2 + 7 = 9,
> return [0, 1].
> ```

```java
import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            int send=target-nums[i];
            if(map.containsKey(send)){
                //找到
                int j=map.get(send);
                result[1]=i;
                result[0]=j;
                break;
              //  return result;
            }else{
                map.put(nums[i],i);
            }
            
        }
        return result;
    }
}
```

### java 中haspmap的使用:

+ HashMap与TreeMap 的区别: HashMap通过hashcode对其内容进行快速查找，而TreeMap中所有元素都保持某种规定的顺序。如果你需要得到一个有序的结果你就应该使用TreeMap（HashMap中的顺序不是固定的。）
+ HashMap的API

> ```
> void                 clear()
> Object               clone()
> boolean              containsKey(Object key)
> boolean              containsValue(Object value)
> Set<Entry<K, V>>     entrySet()
> V                    get(Object key)
> boolean              isEmpty()
> Set<K>               keySet()
> V                    put(K key, V value)
> void                 putAll(Map<? extends K, ? extends V> map)
> V                    remove(Object key)
> int                  size()
> Collection<V>        values()
> ```

+ haspmap的遍历

```java
for(String k:map.keySet()){
        	System.out.print(map.get(k)+" ");
        }
        /*下面通过迭代器来进行遍历*/
        // 假设map是HashMap对象
// map中的key是String类型，value是Integer类型
Integer integ = null;
Iterator iter = map.entrySet().iterator();
while(iter.hasNext()) {
    Map.Entry entry = (Map.Entry)iter.next();
    // 获取key
    key = (String)entry.getKey();
        // 获取value
    integ = (Integer)entry.getValue();
}
```

### java中集合类小问题说明

+ java集合类的基本接口有哪些

java集合类提供了一套设计良好的支持对一组对象进行操作的接口和类。java集合类里面最基本的接口有：

1. Collection:代表一组对象，每一个对象都是它的子元素
2. Set: 不包括重复元素的Collection
3. List: 有顺序的collection,并且可以包含重复元素
4. Map: 可以把键映射到值的对象，键不能重复

+ 为什么集合类没有实现Cloneable和Serializable接口

集合类接口指定了一组叫做元素的对象。集合类接口的每一种具体实现都可以选择以它自己的方式对元素进行保存和排序。有的集合类允许重复键，有些不允许。

+ 什么是迭代器？

Iterator接口提供了很多对几何元素进行迭代的方法。每个集合类都包含了可以返回得带起实例的迭代方法，迭代器可以在迭代的过程中删除底层几何元素。克隆或序列化的语义和含义是跟具体的实现相关，因此，应该由集合类的具体实现来决定如何被克隆或者序列化。

+ Iterator和ListIterator的区别是什么？

1. Iterator可用来遍历Set和List集合。但ListIterator只能用来遍历List
2. Iterator对几何只能是前向遍历，ListIterator既可以前向也可以后向
3. ListIterator实现了Iteroator接口，并包含其他功能，比如：增加元素，替换元素，获取前一个和后一个元素

+ java中HashMap的工作原理？

java中的hashmap是以键指对的形式存储元素的。Hashmap需要一个hash函数，它使用hashcode（）和equals（）方法来想集合添加和检索元素。当调用put（）方法时，hashmap会计算key的hash值，然后把键值对存储在集合的合适索引上。如果key值已存在，value会被更新。hashmap的一些重要特性是它的容量，负载因子和扩容极限。

+ hashcode（）和equals()方法的重要性体现在什么地方？

java中hashmap使用hsahcode（）和equals（）方法来确定键值对的索引，当根据键获得取值的时候也会用到这两个方法。如果没有正确的使用这两个方法，两个不同的键可能会有相同的hash值，因此，可能会被集合认为是相等的。而且这两个方法也用来发现重复元素。所以这两个方法的实现对hashmap的精确性和准确性是至关重要。

+ hashmap和hashtable有什么区别

hashmap和hashtable都实现了map接口，因此有很多特性都相似。但有以下不同点：

1. hashmap允许键和值时null，而hashtable不允许键或值是null
2. hashtable是同步的，哈什蚂怕不是。因此HashMap更适合用于单线程环境，而hashtable适合用于多线程环境。
3. HashMap提供了可供应用迭代的键的集合，因此，hashmap是快速失败的。另一方面，hashmap提供了对键的列举。

+ 数组（Array）和列表（ArrayList）有什么区别？什么时候应该使用Array而不是ArrayList？

1. Array可以包含基本类型和对象类型。ArrayList只能包含对象类型。
2. Array是大小固定的，ArrayList的大小是动态变化的
3. ArrayList提供了更多的方法和特性。对于基本类型数据，集合使用自动装箱来减少编码工作量

+ ArrayList和LinkedList有什么区别？

ArrayList和LinkedList都实现了List的接口，他们有以下不同点：

1. ArrayList是基于索引的数据接口，它的底层是数组，可以以O(1)的时间复杂度对元素进行随机访问。LinkedList是以元素列表形式存储它的数据。每一个元素和它前一个和后一个元素连接在一起，在此情况下找到某个元素的时间复杂度O(n).
2. 相对于ArrayList，LinkedList的插入，添加，删除操作速度更快
3. LinkedList比ArrayList更占内存

+ Comparable 和Comparator 接口是干什么的？列出它们的区别。

  Java 提供了只包含一个 compareTo() 方法的 Comparable 接口。这个方法可以个给两个对象排序。具体来说，它返回负数，0，正数来表明输入对象小于，等于，大于已经存在的对象。

  Java 提供了包含 compare() 和 equals() 两个方法的 Comparator 接口。compare() 方法用来给两个输入参数排序，返回负数，0，正数表明第一个参数是小于，等于，大于第二个参数。equals() 方法需要一个对象作为参数，它用来决定输入参数是否和 comparator 相等。只有当输入参数也是一个 comparator 并且输入参数和当前 comparator 的排序结果是相同的时候，这个方法才返回 true。

+ java集合类框架的最佳实践有哪些？

根据应用的需要正确选择要使用的集合的类型对性能非常重要，比如：假如元素的大小是固定的，而且能事先知道，我们就应该用 Array 而不是 ArrayList。 有些集合类允许指定初始容量。因此，如果我们能估计出存储的元素的数目，我们可以设置初始容量来避免重新计算 hash 值或者是扩容。

为了类型安全，可读性和健壮性的原因总是要使用泛型。同时，使用泛型还可以避免运行时的 ClassCastException。

使用 JDK 提供的不变类(immutable class)作为Map的键可以避免为我们自己的类实现 hashCode() 和 equals() 方法。

编程的时候接口优于实现。

底层的集合实际上是空的情况下，返回长度是0的集合或者是数组，不要返回 null。

+ HashSet和TreeSet有什么区别

HashSet 是由一个 hash 表来实现的，因此，它的元素是无序的。add()，remove()，contains()方法的时间复杂度是 O(1)。

另一方面，TreeSet 是由一个树形的结构来实现的，它里面的元素是有序的。因此，add()，remove()，contains() 方法的时间复杂度是 O(logn)。

+ List、Set、Map是否集成自Collection接口

List、Set 是，Map 不是。Map 是键值对映射容器，与 List 和 Set 有明显的区别，而 Set 存储的零散的元素且不允许有重复元素（数学中的集合也是如此），List 是线性结构的容器，适用于按数值索引访问元素的情形。

+ 说出ArrayList、Vector、LinkedList的存储性能和特性？

ArrayList 和 Vector 都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢，Vector 由于使用了 synchronized 方法（线程安全），通常性能上较 ArrayList 差，而 LinkedList 使用双向链表实现存储（将内存中零散的内存单元通过附加的引用关联起来，形成一个可以按序号索引的线性结构，这种链式存储方式与数组的连续存储方式相比，其实对内存的利用率更高），按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。

Vector 属于遗留容器（早期的 JDK 中使用的容器，除此之外 Hashtable、Dictionary、BitSet、Stack、Properties 都是遗留容器），现在已经不推荐使用，但是由于 ArrayList 和 LinkedListed 都是非线程安全的，如果需要多个线程操作同一个容器，那么可以通过工具类 Collections 中的 synchronizedList 方法将其转换成线程安全的容器后再使用（这其实是装潢模式最好的例子，将已有对象传入另一个类的构造器中创建新的对象来增加新功能）

# climbStairs 爬楼梯

> 你要爬一个楼梯。到达楼梯顶部需要N个步骤，每次你可以爬1步或2步。有多少种不同的方法可以爬到顶部？

> 首先最直接的方法是采用递归。因为每次只走1阶或2阶，因此走上n阶等于走上第N-1阶和第N-2阶的和（因为走到N阶等于先走到N-1j阶再走1阶或等于走到N-2阶再走2阶）。利用
> $$
> f(n)=f(n-1)+f(n-2),f(1)=1,f(2)=2
> $$
>

代码实现如下：

```java
public int climbStairs(int n){
  if(n==0||n==1){
    return 1;
  }
  return climbStairs(n-1)+climbStairs(n-2);
}
```

> 动态规划的数组实现：使用数组揭发，我们需要创建一个大小为n+1的数组。如果说递归揭发是自定向下的话，数组实现的动态规划是自底向上的。在这个算法中，和递归解法是自顶向下的话，数组实现动态规划即自底向上。只是将
> $$
> f(n)=f(n-1)+f(n-2) 换成 result[n]=result[n-1]+result[n-2]即可
> $$
>

```java
public int climbStaris(int n){
  public int climbStairs(int n) {
        int[] result=new int[n+1];
        if(n==1||n==0) return 1;
        if(n>=2){
          result[0]=1;
           result[1]=1;
            for(int i=2;i<=n;i++){
                result[i]=result[i-1]+result[i-2];
            }
        }
        return result[n];
    }
}
```

# 数字回文

> 判断一个整数是否为回文，不要使用额外空间完成这一任务。一些提示：负数能够是回文吗？如果你考虑将一个整数转换成一个字符串，注意不允许使用额外空间的限制。如何处理这种情况？还有一种更通用的方法来解决问题。

把一个整数转换成字符串来进行判断，代码如下：

```java
import java.util.Scanner;

public class Palindrom {
public static void main(String[] args){
	Scanner scanner=new Scanner(System.in);
	int x=scanner.nextInt();
    String str=String.valueOf(x);
    boolean flag=true;
    int i=0,j=0;
    if(x<0) flag=false;
    for(i=0,j=str.length()-1;j>=i;i++,j--){
        if(!(str.charAt(i)==str.charAt(j))){
            flag=false;
            break;
        }
    }
    System.out.println(flag);
   
}
}

```

 这道验证回文数字的题不能使用额外空间，意味着不能把整数变成字符，然后来验证回文字符串。而是直接对整数进行操作，我们可以利用取整和取余来获得我们想要的数字，比如 1221 这个数字，如果 计算 1221 / 1000， 则可得首位1， 如果 1221 % 10， 则可得到末尾1，进行比较，然后把中间的22取出继续比较。代码如下

```java
class Solution {
public
    boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;//注意这里对x如何取值
            div /= 100;//注意这里是除以100
        }
        return true;
    }
}
```

# 罗马数字转换整数

> 罗马数字是[阿拉伯数字](http://baike.baidu.com/item/%E9%98%BF%E6%8B%89%E4%BC%AF%E6%95%B0%E5%AD%97)传入之前使用的一种数码。罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。记数的方法：
>
> 1. 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
> 2. 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
> 3. 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
> 4. 在一个数的上面画一条横线，表示这个数增值 1,000 倍，如

代码如下：

```java
public class Solution {
    public int romanToInt(String s) {
      int nums[]=new int[s.length()];
    for(int i=0;i<s.length();i++){
      /*把字符串对应的整数列出来，注意索引0的在索引1的右边，因此索引0的是最高位，索引越大越是低位*/
        switch (s.charAt(i)){
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
        }
    }
    int sum=0;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]<nums[i+1])//判断小数在大数的右边
            sum-=nums[i];
        else
            sum+=nums[i];
    }
    return sum+nums[nums.length-1];//注意这里结果要加上num[length-1]
    }
}
```

# 寻找若干个字符串的最长公共前缀

> 给出若干个字符串，找出他们的最长公共前缀子串

> 方法：
>
> 1. 所求的最长公共前缀子串一定是每个字符串的前缀子串，所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，看是否是他们所有人的前缀子串，这里时间性能是O(mnm);
> 2. 列出所有的字符串的前缀子串，将它们合并后排序，找出其中个数为n且最长的裙子穿。时间性能为
>
> O(nm+mnlog(mn))
>
> 3. 纵向扫描，从下标零开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。时间性能为O（nm）

这里采用第三种方法来实现（纵向扫描），代码如下：

```
  public  static String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        
        int i = 1;
        while(i < strs.length){
        	System.out.println("i:"+i);
            while(strs[i].indexOf(pre) != 0){
            	 pre = pre.substring(0,pre.length()-1);
            } 
            i++;
        }
        return pre;   
    }
```

> ```
> public int indexOf(String str) 如果此方法返回的字符串参数发生这个对象内的子字符串，然后返回第一个此类子串的第一个字符的索引，如果它不发生的一个子串，则返回-1
> ```

### 最大公共前缀

> 最大公共前缀，意味着该前缀出现在所有字符串中，所以对于每个字符，去比较所有的字符串，如果该字符出现在所有字符串中，则添加该字符到前缀字符串中，否则，结束搜索。

代码如下：

```java
public static StringBuffer LongCommon(String[] strs){
    	StringBuffer str =new StringBuffer("");
    	if(strs.length==0) return str;
    	int len=0;
    	while(true){
    		char var =' ';
    		int i=0;
    		for(;i<strs.length;i++){//对字符串数组进行遍历
    			if(i==0) var =strs[0].charAt(len);//var存放的是第一个字符串中字符
    			//当出第一个字符串外的其他字符串，如果其长度==len或存在var
    		    //不出现在该字符串中则跳出询循环
    			if(strs[i].length()==len||strs[i].charAt(len)!=var) break;
    		}
    		/*该循环是对第一个字符串的len个字符与其他字符串的len字符比较，
    		 * 判断是否相同，一旦存在不同就跳出否则比较完在跳出
    		 */
    		if(i!=strs.length) break;//说明不存在公共前缀字符串，跳出while循环
    		len++;
    		str.append(var);
    		
    	}
		return str;
    	
    }
```



# 2017-4-13

# 寻找插入位置

> ```
> 给定排序的数组和目标值，如果找到目标，返回索引。如果没有，如果按顺序插入索引就返回索引。您可以假定阵列中没有重复项。
> ```

> 我们在这里考虑使用类似二分查找法来解决问题，因为是有序数组的查找。有序数组的查找还有一种方法是顺序查找。

代码如下：

```java
 public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;//这种情况下 nums[mid]<=target
        }
        return low;
    }
```

首先我们要注意一点，注意java对中点的计算为

int mid=first+(last-first/2) 而非

int mid=(first+mid)/2

因为如果数组元素超过2^30，first与last的和会超过int的范围，因此first和last的和会溢出变成一个负数，导致mid成一个负数。用mid=first+(lasy=first)/2可以避免这个错误。

+ 二分查找

```
boolean binsearch(int first ,int last,T desiredItem){
  boolean found;
  int mid=first+(last-first)/2;
  if(first>last) fonud=false;
  else if(desiredItem.equals(list[mid]))
      found=true;
  else if(desiredItem.compareTo(list[mid])<0)
       found=binseaqrch(first,mid-1,desiredItem);
   else found=binsearch(mid+1,last,desiredItem);
   return found;
}
```

+ 顺序查找

```
boolean search(int first,int last,T desiredItem){
  boolean found;
  if(first>last ) found=false;
  else if(desireaItem==list[first]) found=ture;
  else search(first+1,last,desiredItem);
  return found;
}
```

# 2017-4-14

## 括号匹配

> 给定一个字符串，它只包括诸如这样的字符:'(' ,')','{','}','[',']'。括号必须以正确的顺序结束，'()'和'(){}[]'都是有效的。但'(}'和”（[）]“是无效的。

这道题目是典型栈匹配题目。维持一个栈，遇到右括号的时候出栈，最后检查栈是否为空。

代码如下:

```java
import java.util.Stack;
public class ValidParentheses {
    public static boolean isValid(String s) {
        boolean flag=true;
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            System.out.println(c);
            switch(c){
                case '(':
                case '[' :
                case '{' : 
                	System.out.println("test1");
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                	if(stack.isEmpty()){
                		flag=false;
                	}else{
                		System.out.println("test2");
                		 char peek=stack.peek();//注意这里用peek
                         flag=isPair(peek,c);
                      /*这里对falg的判断*/
                         if(flag){
                        	 stack.pop();
                         }else{
                        	 stack.push(c);
                         }
                         System.out.println("C:"+c+" "+" peek:"+peek+" "+flag);
                         break;
                	}
                   
                default: 
                	System.out.println("test");
                	continue;
            }
           
        }
         if(!stack.isEmpty()){
                flag=false;
            }
     return flag;
    }
    public static boolean isPair( char first, char sencond){
      //对isPair的定义
        return (first=='('&&sencond==')')||(first=='{'&&sencond=='}')||(first=='['&&sencond==']');
    }
    }
```

## 中缀到后缀的转换

为了将中缀表达式转换为后缀表达式，在从左到右的处理中缀表达式时，根据所遇到的符号，采取下列的行动策略：

+ 操作数   将每个操作数添加到输出表达式的末尾
+ 运算符^  push^到栈中
+ 运算符 +、-、*、/  从栈中pop运算符，将它们添加到输出表达式的末尾，直到栈空或者栈定元素的优先级比新的运算符低。然后将新的运算符push到栈中
+ 左括号   将（ 运算符push到栈中
+ 右括号  从栈中pop运算符，将它们添加到输出表达式的末尾，直到pop出一个左括号为止。丢弃这两个括号。



## 后缀表达式求值



## 中缀表达式求值

##  

## 合并两个排序好的链表 

> 将两个排序的链表合并，并返回一个新的链表。新的链表应通过将前两个链表中元素合并到一起而形成。

> 这道题目用双指针分别扫描两个链表，扫描过程中，不断比较连个指针指向的链表节点的值，将值小的加点出入到新链表中。

由于java中对指针支持较弱，我们这道题采用递归的方法来解决，代码如下：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
}
```

## 从排序的数组中删除重复的元素

> 给定一个排序的数组，就地删除重复元素，以便每个元素出现一次，并且返回新的数组长度

> 思路：题目已经提到，这是一个有序的数组，这点降低了题目的难度。可以使用双指针，一前一后扫描来解决这个问题。前面的指针用于遍历数组元素，后面的指针用于维持非冗余元素的右边界。因为数组有序，所以前面的指针在扫描过程中，如果等于后面的指针的值，则是冗余数据，跳过，否则将该元素插入到第一个指针的后面，并将第一个指针的下标加1.

添加关于continue 、break的知识：

### 循环辅助手段：continue和break

> 一般来说，进入循环体以后，在在此循环判断之前执行循环体内的所有语句。continue和break语句是您可以根据循环体内进行的结果判断来忽略部分循环甚至终止它。
>
> + continue语句
>
> 该语句可以用于三种循环形式。当运行到该语句的时候，它将导致剩余的迭代部分被忽略，开始下一次迭代。如果continue语句用于嵌套结构中，那么它仅仅影响包含它的最里层的结构
>
> + break语句
>
> 循环中的break语句导致程序终止包含它的循环，并进行程序的下一阶段。如果break语句位于嵌套循环里，它影响包含它最里层的循环。

> 解题思路是，遍历数组，如果是冗余数字的话则跳出循环，否则将元素覆盖冗余数字。

代码如下：

```java
public class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length==0) return 0;
    int j=0;
    for (int i=0; i<nums.length; i++)
        if (nums[i]!=nums[j]) nums[++j]=nums[i];
    return ++j;
    }
}
```

这段代码和下面代码思路一样：

```java
public static  int removeDupicates(int[] A){
		if(A.length==0) return 0;
		int index=0;
		for(int i=0;i<A.length;i++){
			if(A[i]==A[index]) continue;//如果相同则跳过，i++,
			index++;
			A[index]=A[i];
		}
		for(int i: A){
			System.out.print(i+" ");
		}
		System.out.println();
		return index+1;
	}
```

## 删除元素

> 给定一个数组和一个值，就地删除该值的所有实例，并且返回新的长度。元素的顺序可以改变。超出新长度的部分的内容是什么，无关紧要。

> 这是个双指针问题用一个下标A来遍历数组，用另一个下标B来维护新的字符串的右边界。假设题目要求移除所有大小为N的元素，在下标A遍历数组元素的过程中，如果等于N，则跳过，否则，则插入下标B指向的位置，同时B的值加1.

代码如下：

```java
public class Solution {
    public int removeElement(int[] nums, int val) {
        int cur=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val) continue;
            nums[cur]=nums[i];
            cur++;
        }
        return cur;
    }
}
```

# 2017-4-19

## 最大子数组

> 求出一个数组中连续的子数组（至少包含一个数字），而该子数组拥有最大的和。例如，给定数组[-2,1,-3,4,-1,2,1,-5,4],连续数组[4,-1,2,1]拥有最大的和sum=6.

> 更进一步的练习： 如果你找到O(n)的解决方案，尝试使用分而治之的方法来编写另一个解决方案，这更巧妙一些。

解题思路：

事实上，可以令currSum是以当前元素结尾的最大子数组和，maxSum是全局的最大子数组和，当往后扫描时，对第j个元素有两种选择：要么放入前面找到的子数组，要么做为新子数组的第一个元素：如果currSum

 > 0，则令currSum加上a[j]，反之，currSum  < 0 时，则currSum 被置为当前元素，即currSum =
 >  a[j]。


相当于如果设currSum(j)为以j结尾的最大连续子数组和，那么currSum(j) = max{0, currSum[j - 1]}

+a[j]。且当maxSum < currSum时，则更新maxSum = currSum，否则maxSum保持原值，不更新。

代码如下：

```java
 public static int maxSubArray1(int[] nums) {
	        int res = Integer.MIN_VALUE, curSum = 0;
	        for (int num : nums) {
	        	System.out.println("num:"+num);
	            curSum = Math.max(curSum + num, num);
	            System.out.println("curSum:"+curSum);
	            res = Math.max(res, curSum);
	            System.out.println("res:"+res);
	        }
	        return res;
	    }
```

## 最后一个单词的长度

> 给定一个字符串s，其中包含了大写/小写字母和空格字符' ',返回字符串中，最后一个单词的长度。如果不存在最后一个单词，返回0.注意，一个单词的定义为只包含非空格字符的一个字符序列。例如，给定s="hello world" ,返回5.

算法从后往前扫描数组，跳过空格的第一个单词即为所求。（这里注意从后往前扫描会更容易求解）

代码如下：

```java
public class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int count=0;
        for(int j=n-1;j>=0;j--){
            if(s.charAt(j)==' '){
                if(count==0) continue;
                else return count;
            }
            count++;
        }
        return count;
    }
}
```

还有一种巧妙的思路：只有一行java代码

```java
public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}
```

## 加1

> 给定一个数字，它表示数字的一个数组，给该数字加1.如给定一个数组127,表示为[1,2,7],给数字加1,输出[1,2,8]

> 主要是模拟加法的过程，注意处理进位即可。

代码如下：

```java
public int[] plusOne(int[] digits){
  int carry=1;
  int index=digits.length-1;
  while(index>=0&&carry>0){
    digits[index]=(digits[index]+carry)%10;
    carry=digits[index]==0 ? 1:0;
    index--;
  }
  if(carry==0)//说明出现这种情况了，[9,9,9]加1出现1000
    {
      digits=new int[digits.length+1];
    digits[0]=1;
    }
  return digits;
}
```

## 二进制加法

> 给定两个二进制字符串，返回他们的加和（也是一个二进制字符串）。例如: a="11",b="1",返回 100

代码如下:

```java
public String addBinary(String a, String b) {
        int  carry=0;//标志是否进位
        StringBuffer strbuffer=new StringBuffer();
        int alen=a.length();
        int blen=b.length();
        for(int i=alen-1,j=blen-1;i>=0||j>=0;i--,j--){//注意这里的条件是i>=0||j>=0
           int ai= i>=0? a.charAt(i)-'0':0;//注意这里使用三元运算符，同时注意字符转int
            int bi=j>=0? b.charAt(j)-'0':0;
            int val=(ai+bi+carry)%2;//本位
            carry=(ai+bi+carry)/2;//进位
            strbuffer=strbuffer.append(val);
        }
        if(carry==1){
            strbuffer=strbuffer.append('1');
        }
        return strbuffer.reverse().toString();
    }
```

# 2017-4-20

## sqrt(X)

> 实现 int sqrt(X),计算并返回x的平方根

> 我们这里使用牛顿法来求解问题。首先设函数 $$ f(x)=x^2-n=0 $$   ,求得x值即为所求结果。
>
> 我们利用牛顿法来求解，首先该函数的导数为$$ f'(x)=2x $$   .首先取$$ x_0 $$ ,如果$$ x_0 $$ 不是解的话，做一个将经过$$ (x_0,f(x_0) $$ 的切线，切线与x轴的交点作为$$ x_1 $$ .即 $$ (x-x_0)(2x)=y-f(x_0) $$  ===>求解得 $$ x_1=x_0-f(x)/2x_0 $$  .所以牛顿法的迭代公式为 $$ x_{i+1}=x_{i}-f(x)/2x_{i}=x_{i}-(x_{i}^2-n)/2x_{i}=(x_{i}+n/x_{i})/2 $$ .  另外使用迭代法需要注意的是迭代溢出问题。（因为该问题是求解结果转换为整型）

代码如下:

```java
int sqrt(int x){
  if(x==0) return x;
  double last=0;
  double res=1;
  while(res!=last){
    last=res;
    res=(res+x/res)/2
  }
  return int(res);
}
//注意 x是上式中的n，res为推导公式中的x
```

## 从排序链表中删除重复元素

> 给定一个排序的链表，删除所有重复元素，以便每一个元素只出现一次。例如，给定了1->1->2,返回1->2.给定了1->1->2->3->3 ，返回1->2->3

这里给出一个递归的求解方法:

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
```

还有一个非递归的解法：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;
         
         while(list != null) {
        	 if (list.next == null) {
        		 break;
        	 }
        	 if (list.val == list.next.val) {
        		 list.next = list.next.next;
        	 } else {
        		 list = list.next;
        	 }
         }
         
         return head;
    }
}
```

注意这段代码中，java对链表的处理。

## 合并两个排序的数组

> 给定两个排序的整数数组A和数组B，将B合并到A中，形成一个排序数组。注意你可以假设A由足够的空间来保存B中额外的元素。A和B中最初的元素分别为m和n。

>解析： 简单说就是从后往前填空。因为题目已提到，A有足够的空间来存储合并后的元素，所以从后往前把两个数组倒填到A里面就可以了。（注意这里不能前向填空，因为要把数组B合并到数组A中，前向填空容易覆盖掉数据，因此只能后向填空。如果是合并数组为第三个数组这样的话可以使用前向填空）

代码如下：

```java
public void merge(int[] nums1 ,int n,int[] nums2,int m){
  int k=m+n-1;
  int i=n-1;
  int j=m-1;
  for(;i>=0&&j>=0;k--){
    if(nums1[i]>nums2[j]){
      nums1[k]=nums1[i];
      i--;
    }else{
      nums1[k]=mums2[j];
      j--;
    }
  }
  while(j>=0){
    nums1[k]=nums2[j];
    j--;
    k--;
  }
}
```

如果使用第三个数组来存储数据，即合并到第三个数组的话可以这样做：

```java
public int[] merge(int[] nums1,int[] nums2){
  int i=0;
  int j=0;
  int k=0;
  int[] result=new int[m+n];
  while((i<=nums1.length)&&(j<=nums2.length)){
    if(nums1[i]>nums2[j]){
      result[k]=nums2[j];
      j++;
      k++;
    }else{
      result[k]=nums1[i];
      i++;
      k++;
    }
   
  }
   while(i<=num1.length){
      result[k]=nums1[i];
      i++;
      k++;
    }
    while(j<=nums2.length){
      result[k]=nums2[j];
      j++;
      k++;
    }
    return result;
}
```

## 判断树是否相同

> 给定两个二叉树，判断这两个树是否相同。二叉树相同要求他们在结构上相同且具有相同的值。

> 关于树的问题多大数都可使用递归方法来处理。

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
public boolean isSameTree(TreeNode p,TreeNode q){
  if(p==null&&q==null) return true;
  if(P==null||q==null) return false;
  if(p.val==q.val) 
      return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
  return false;
}
```

# 判断二叉树是否是中心对称

> 给定一个二叉树，判断它是否为中心对称

> 关于树的问题，仍沿用递归算法。但要注意本题和上一题的区别：上一题判断树是否相同，比较的是左子树和左子树，右子树和右子树。但中心对称比较的是左子树和右子树，右子树和左子树。

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
    public boolean isSymmetric(TreeNode root) {
        boolean flag=false;
        if(root==null) flag=true;
        else{
              flag=isSame(root.left,root.right);
        }
     return flag;
    }
    public boolean isSame(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null|| root2==null) return false;
        if(root1.val==root2.val) 
          return isSame(root1.left,root2.right)&&isSame(root1.right,root2.left);
        return false;
    }
    }
```

# 2017-4-21

## 二叉树最大深度

> 给定一个二叉树，找到其最大深度。最大深度是从根节点到最远叶节点的最长路径中的节点数。

> 定义Max[K]是以K为根节点的子树的最大长度，那么，递推方程可以归纳为：$$ Max[K]=max(Max[K->left],Max[K->right])+1 $$  .关于树的问题还是一如既往的使用递归方法。

代码如下:

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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int lmax=maxDepth(root.left);
        int rmax=maxDepth(root.right);
        return Math.max(lmax,rmax)+1;
    }
}
```

> **java.lang.Math.max(double a, double b)** 返回较大的两个double值。即，其结果是更接近正无穷的参数。如果参数具有相同的值，其结果是相同的值。如果两个值是NaN，那么结果为NaN。数值比较运算不同的是，此方法认为负零严格小于正零。如果一个参数是正零和负零，结果是正零。

另一种方法是对树按层访问，并统计层数。也就是树的层次遍历。

代码如下:

## 二叉树层次遍历

> 给定一个二叉树，返回自上而下的顺序遍历其节点值（即从左到右，从叶到根逐级）。如给定二叉树[3,9,20,null,null,15,7],返回[[15,7],[9,26],[3]].

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root==null) return result;
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while(q.size()>0){//该句与while(!q.isEmpty())等效
        List<Integer> list = new ArrayList<>();
        int size = q.size();
        for(int i=0; i<size; i++){
            TreeNode node = q.poll();//检索并删除此列表的头（第一个元素）
            list.add(node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        result.add(0,list);//在特定位置插入元素，相对与每次表头插入，故根在result的尾部
    }
    return result;//result的大小就是二叉树的最大深度
    }
}
```

## 将排序的数组转换为二叉树

> 给定一个数组，其中元素按升序排列，将其转换为平衡二叉树

> 平衡二叉树具有以下性质：它是一颗空树或它的左右两个子树的高度差的绝对值不超过1,并且左右两个子树都是一颗平衡二叉树。明显平衡二叉树的定义具有递归性。那么如何将一个排序数组转换成平衡二叉树？我们需从上往下进行重构，即
>
> 1. 以数组中间元素为根节点
> 2. 中间元素左边的所有元素为左子树节点
> 3. 中间元素右边的所有元素为右子树节点
> 4. 递归执行步骤1～步骤3

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    public static  TreeNode buildTree(int[] nums,int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(nums[mid]);
         node.left=buildTree(nums,start,mid-1);
         node.right=buildTree(nums,mid+1,end);
        return node;
    }
}
```

## 将排序的链表转换为二叉树

> 给定一个单向链表，其中的元素都按升序排序的，将其转换为一个高度平衡的BST。

> 本题与上一题的区别在于：一个为数组，一个为链表。根据上一题的思路，我们需要找到中间元素，中间之前的所有节点均为左子树，中间元素之后均为右子树。本题与上一题类似，但是链表的访问方式和数组不同，自上往下的构建意味着先构建根节点，然后构建其左右子节点。因为数组是顺序存储的，所以二叉树搜索树的遍历数组可以在O(1)的时间内通过操作找到跟节点及其左右节点。按照自上而下构造节点是合理的。
>
> 而链表对于元素的访问，则需要通过遍历的方式来获得，除非遍历整个链表，否则无法知道中间元素是哪一个。所以对于链表，需要转换思路，通过自下往上的方式重构树：
>
> 1. 获得当前链表的长度
> 2. 中序遍历树，在遍历过程中创建节点
>
> 自下往上的好处是，把链表当作树的中序遍历结果，反向地重构树，这样就不需要寻找中间节点了。

代码如下：

```c++
TreeNode *sortListToBST(ListNode *head){
  int len=0;
  ListNode *p=head;
  while(p){
    len++;
    p=p->next;
  }
  return BuildBST(head,0,len-1);
}
TreeNode* BuildBST(ListNode * list,int start,int end){
  if(start>end ) return NULL;
  int mid=(start+end)/2;
  TreeNode *leftChild=BuildBST(list,start,mid-1);
  TreeNode *parent=new TreeNode(list->val);
  parent->left=leftChild;
  list=list->next;
  //注意以上几句的顺序,不能更改。因为是自下往上构建树的，所以先有儿子后有父母
  parent-right=BuildBST(list,mid+1,end);
  return parent;
}
```

## 平衡二叉树

> 给定一个二叉树，判断他们是否是平衡二叉树

> 这个问题，可以使用递归来判断。需要写一个函数：判断树的高度

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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int val=GetBalance(root);
        if(val==-1) return false;
        return true;
       // return isBalanced(root.left)&&isBalanced(root.right);
    }
    int GetBalance(TreeNode root){
        if(root==null) return 0;
        int left=GetBalance(root.left);
        if(left==-1) return -1;
        int right=GetBalance(root.right);
        if(right==-1) return -1;
        if(left-right<-1 || left-right>1){
            return -1;
        }
      //注意这里判断的条件（left-right<-1 || left-right>1）
        return Math.max(right,left)+1;
        
        
    }
}
```

## 二叉树的最小深度

> 给定一个二叉树，求其最小深度。最小深度是从根节点从

> 定义Max[K]是以K为根节点的子树的最大长度，那么，递推方程可以归纳为：$$ Min[K]=min(Min[K->left],Min[K->right])+1 $$  .关于树的问题还是一如既往的使用递归方法。同时又要比二叉树的最大深度多考虑一些情况，如左子树为要把左子树赋值为Integer.MAX_VALUE,同理右子树为零也同样处理。还左右子树同时为零的情况。
>
> 

代码如下:

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
    public int minDepth(TreeNode root) {
         if(root==null) return 0;
        int lmin=minDepth(root.left);
        int rmin=minDepth(root.right);
        if(lmin==0&&rmin==0) return 1;
        if(lmin==0){
            lmin=Integer.MAX_VALUE;
        }
        if(rmin==0){
            rmin=Integer.MAX_VALUE;
        }
        return Math.min(lmin,rmin)+1;
    }
}
```

# 2017-4-23

## 路径加和

> 给定一个二叉树和一个和sum，判断树是否有一个根到叶子的路径，其路径上所有值的加和等于给定的sum。

> 对于一个二叉树进行前序遍历，遍历过程中累加节点，当达到任意叶节点的时候，进行判断，如果等于给定值，则返回，否则继续搜索。（树的问题是递归来处理的比较多）

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
    public boolean hasPathSum(TreeNode root, int sum) {
         return hasPath(root,0,sum);
        
    }
    public boolean  hasPath(TreeNode root,int sum,int target){
      /*这里函数有三个参数其中sum 和target 这两个参数是必须的，因为没有的话，在递归的时候就不能判断什么*了，也就是说在递归的时候需要记录当前的sum和target，因此把他设置成参数是必须的*/
        if(root==null) return false;
        sum=sum+root.val;
        if(root.left==null&&root.right==null){
            if(sum==target) return true;
            else return false;
        }
        return hasPath(root.left,sum,target)||hasPath(root.right,sum,target);
    }
    
}
```

## Pascal三角

> 给定一个索引，返回pascal三角的第k行，例如给分in个k=3，返回[1,3,3,1].
>
> > [
> >
> > [1],
> >
> > [1,1],
> >
> > [1,2,1],
> >
> > [1,3,3,1],
> >
> > [1,4,6,4,1]
> >
> > ]
>
> 注意是否能够优化你的算法，以便使用o(k)的额外空间

> 杨辉三角性质：
>
> **前提：每行端点与结尾的数为1.**
>
> 1. 每个数等于它上方两数之和。
> 2. 每行数字左右对称，由1开始逐渐变大。
> 3. 第n行的数字有n项。
> 4. 第n行数字和为2n-1。
> 5. 第n行的m个数可表示为 *C(n-1，**m-1)*，即为从n-1个不同元素中取m-1个元素的组合数。
> 6. 第n行的第m个数和第n-m+1个数相等 ，为[组合数](http://baike.baidu.com/item/%E7%BB%84%E5%90%88%E6%95%B0)性质之一。
> 7. 每个数字等于上一行的左右两个数字之和。可用此性质写出整个杨辉三角。即第n+1行的第i个数等于第n行的第i-1个数和第i个数之和，这也是组合数的性质之一。即 *C(n+1,i)=C(n,i)+C(n,i-1)*。
> 8. (a+b)n的展开式中的各项[系数](http://baike.baidu.com/item/%E7%B3%BB%E6%95%B0)依次对应杨辉三角的第(n+1)行中的每一项。
> 9. 将第2n+1行第1个数，跟第2n+2行第3个数、第2n+3行第5个数……连成一线，这些数的和是第4n+1个[斐波那契数](http://baike.baidu.com/item/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0)；将第2n行第2个数(n>1)，跟第2n-1行第4个数、第2n-2行第6个数……这些数之和是第4n-2个斐波那契数。
> 10. 将各行数字相排列，可得11的n-1（n为行数）次方：1=11^0; 11=11^1; 121=11^2……当n>5时会不符合这一条性质，此时应把第n行的最右面的数字"1"放在个位，然后把左面的一个数字的个位对齐到十位... ...，以此类推，把空位用“0”补齐，然后把所有的数加起来，得到的数正好是11的n-1次方。以n=11为例，第十一行的数为：1,10,45,120,210,252,210,120,45,10,1，结果为 25937424601=1110。

```
定义T[i][j]为该三角形第i行，第j列的元素，所以可以获得递推函数为 T[i][j]=T[i-1][j]+T[i][j-1] if i>0&&j>0. OR  =1 if(i=1)
          OR  =T[i-1][j] if j=1
```

代码如下：

```java
public class Solution {
  /*这段代码1。首先注意traingle和row的定义2.要注意什么条件下取1，（j==0||j==i）3.注意这里如何利用上一
  *行的结果的特殊性*/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<List<Integer>>();
        if(numRows<0) return triangle;
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                if(j==0||j==i){
                    row.add(1);
                } 
                else{
                row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
            }
            }
            triangle.add(row);
        }
       return triangle; 
    }
}
```

## Pascal 三角

> 给定一个索引k，返回pascal三角的第k行，例如，给定k=3,返回[1,3,3,1]

本题与上一题的区别在与：本题只返回第k行，上一题则返回所有行

代码如下：

```java
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
	if (rowIndex < 0)
		return list;

	for (int i = 0; i < rowIndex + 1; i++) {
		list.add(0, 1);
		for (int j = 1; j < list.size() - 1; j++) {
			list.set(j, list.get(j) + list.get(j + 1));
		}
	}
	return list;
    }
}
```

# 2017-4-24

## 购买和销售股票的最佳时机

> 假设你有一个数组，其中第i个元素是一支给定的股票在某一天i的价格。如果最多只允许你完成一次交易，设计一个算法，来找到最大的盈利点

> 这个题目比较简单，因为题目只要求只能交易一次，所以只要能找到数组中任意两个元素间的最大差值即可。当从左往右扫描数组的时候，用两个变量来记录当前最低价minV和当前最大利润maxP.对于每个数组元素，计算其与最低价的minV的差价，如果差价小于maxP，那麽该元素不可能维所求的元素，直接跳过。如果差价大于maxP,则该元素产生更大利润，用该差价替换maxP.

代码如下：

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int  len=prices.length;
        int minV=Integer.MAX_VALUE;//注意这里赋初值，要赋最大值
        int maxP=0;
        int diff=0;
        for(int i=0;i<len;i++){
            if(prices[i]<minV) minV=prices[i];
            diff=prices[i]-minV;
            if(maxP<diff) maxP=diff;
        }
        return maxP;
    }
}
```

## 购买和销售股票的最佳时机II

> 假设你有一个数组，其第i个元素是给定的股票在某一天i的价格。设计一个算法，来找到最大的盈利点。尼可以进行任意多次的交易。然而你不能同时进行多次交易

> 因为可以多次交易，因此最大利润就是所有交易利润之和。

代码如下：

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int sum=0;
        
        for(int i=1;i<len;i++){
            int diff=prices[i]-prices[i-1];
            if(diff>0) sum=sum+diff;
        }
      /*上面的for循环求相邻差值最简洁，但要注意从1开始*/
        return sum;
    }
}
```

## 验证回文

> 给定一个字符串，判断它是否是一个回文，只考虑字母字符情况，而忽略大小写。例如“A man，a plan ,a canal:Panama” 是一个回文，而"race a car "不是回文。注意如何考虑字符串为空的情况，我们将空窄幅串定义为有效的回文。

> 一个指针从前往后遍历，一个从后往前遍历，边遍历边判断，如果是特殊字符跳过，如果相同，继续如果不同，不是回文循环结束。

代码如下：

```java
public class Solution {
    public boolean isPalindrome(String s) {
        boolean flag=true;
        int len=s.length();
        int start=0;
        int end=len-1;
        if(s.isEmpty()) flag=true;
        while(start<end){
            char first=s.charAt(start);
            char last=s.charAt(end);
            //判断是否是数字或字母，是则转换成小写判断是否相等，否则++
            if (!Character.isLetterOrDigit(first)) {
        		start++;
        	} else if(!Character.isLetterOrDigit(last)) {
        		end--;
        	} else {
        		if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
        			flag=false;;
        		}
        		start++;
        		end--;
        	}
        }
        return flag;
    }
}
```

## 单个数字

> 给定一个整数数组，每个元素都出现一次，只有一个例外的。找到在这个单个的数字。注意尼的算法应该由一个线性的运行复杂度。你是否可以不使用额外的内存来实现算法？

> 简单的说，就是寻找一种方法可以过滤所有出现两次的元素，那麽剩下的哪个即为所求元素。这个可以通过位运算来做，任意两个相同的数，如果做异或运算的话，结果为0.所以，本体解法也很简单，从0开始到n，一路异或下去，最后剩下的值即为所求。

代码如下：

```java
public class Solution {
    public int singleNumber(int[] nums) {
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;
    }
}
```

## 链表中的环

> 给定一个链表，判断其中是否存在环。扩展：你能否不使用额外空间来解决这个问题。

> 使用双指针来遍历，这两个指针步长不一样，如果存在环那麽就能相遇

代码如下：

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       //boolean flag=false;
         if(head==null) return false;;
    ListNode walker = head;
    ListNode runner = head;//不要把runner初始化为head.next,这样容易出现运行时错误
    while(runner.next!=null && runner.next.next!=null) {
        walker = walker.next;
        runner = runner.next.next;//通过这样来使步长不一样
        if(walker==runner) return  true;
    }
    return false;
    }
}
/*还有这里面不用boolean flag=false;这样也会在代码运行时出现运行时错误*/
```

## 设计一个栈

> 设计一个栈具有一下功能：
>
> - push(x) -- Push element x onto stack.
> - pop() -- Removes the element on top of the stack.
> - top() -- Get the top element.
> - getMin() -- Retrieve the minimum element in the stack.
>
> 例如：
>
> ```
> MinStack minStack = new MinStack();
> minStack.push(-2);
> minStack.push(0);
> minStack.push(-3);
> minStack.getMin();   --> Returns -3.
> minStack.pop();
> minStack.top();      --> Returns 0.
> minStack.getMin();   --> Returns -2.
> ```

代码如下：

```java
 import java.util.Stack;
public class MinStack {

  int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

## 两个链表交叉点

> 编写程序以查找两个单链表的交点开始的节点。
>
> 1. 如果两个链表都没有交集，返回null
> 2. 链表在函数返回后必须保留其原始结构
> 3. 可以假定整个连接结构中没有任何环
>
> 代码应优先在O(n)时间内运行，并且仅使用O(1)内存。

代码如下：

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      /*首先进行预处理，使两个链表长度相等*/
   int lenA = length(headA), lenB = length(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private static int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}
}
```

下面再给出另一种求解方法，

代码如下:

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( null==headA || null==headB )
			return null;
		
		ListNode curA = headA, curB = headB;
		while( curA!=curB){
			curA = curA==null?headB:curA.next;
			curB = curB==null?headA:curB.next;
		}
		return curA;
		}
		}
/*有点判断链表是否存在环的感觉，当链表到头，即为null时，回到另一个链表，继续追*/
```

