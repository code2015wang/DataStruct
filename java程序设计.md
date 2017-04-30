# java 7程序设计读书笔记

## 操作符

+ 逻辑求补操作符 ！

这个操作符只能用于boolean基本类型，或者java.lang.Boolean的一个实例。如果操作符为false,那么操作符的值为true。

+ 按位求补操作符

这个操作符的操作数必须是一个整数基本类型，或者是一个整数基本类型的变量。其结果是这个操作数的按位补数。

+ && 与操作符

这个操作符是将两个表达式当做操作数，这两个操作数都必须返回一个可以转换成boolean的值。如果两个操作数的比较结果都是true，它就返回ture。否则返回false.

+ || 或操作符

这个操作符将两个表达式当做操作数，这两个操作数都必须返回一个可以转换成boolean的值，如果其中一个操作数的比较结果为true，它就返回true。

+ 移位操作

1. 左移操作符 <<

左移操作符是将一个数字移位到左边，右边的空位则全补0.n<<s的值是将n左移s位。这相当于乘以2的s次方。

另一条规则是：如果左边的数是一个int，那么将只用移位距离的前5位。换句话说，移位距离必须在范围0--31之间。如果操作数是一个long，那么移位距离是在0--64之间。

2. 右移操作符 >> 是将左边的操作数移到右边。n>>s的值是将n右移s位。生成的值是n/2^s。
3. 无符号右移操作符>>> 

+ 整数按位操作符 & | ^
+ 逻辑操作符 & | ^

## 核心类

+ java.lang.String

1. 比较两个java对象

```
String s1="java";
String s2="java";
if(s1==s2){
  
}
```

这里，（s1==s2）的运算结果是true，因为s1和s2引用同一个实例。

```
String s1=new String("java");
String s2=new String("java");
if(s1==s2){
  
}
```

这里(s1==s2)的记过为false，因为s1和s2引用不同的实例。

这体现了通过编写字符串文本量和使用关键字new创建String'对象之间的区别。

利用==操作符比较两个String对象并没有什么用处，因为比较的是两个变量所引用的地址。

这里一般是用的是equals方法。

2. String类的方法
   + public charAt(int index)
   + public String concat(String s) 将指定字符串连接到这个String的结尾
   + public equals(String anotherString)  比较是否相等
   + public boolean endWith(String suffix) 测试这个Sting是否以指定的后缀结尾
   + public int indexOf(String substring)  返回第一次遇到的指定子字符串的索引。如果没有找到则返回-1
   + public Int lastIndexOf(String  substring)
   + public String substring(int begin,int end)
   + public String replace(char oldChar .char newChar)
   + public int length()
   + public boolean isEmpty()
   + public String[] split(String regEx)
   + public boolean startsWith(String prefix);
   + public char[] toCharArray();
   + public String tolowerCase（）
   + public String toUpperCase();
   + public String trim();
   + valueOf() 静态方法 将基本类型、char数组或者object的一个实例转换成一个字符串表示法。

+ java.lang.StringBuffer 和java.lang.StringBuilder

String对象是不可变的，也不适用于进行添加，或者往他们中插入其他字符。对于添加最好使用java.lang.StringBuffer或者java.lang.StringBuilder类。StingBuffer 适用于多线程的环境且方法是同步的，但牺牲了性能。因此StringBuilder是非同步版

在源代码中，字符串常量不能跨行。

3. Scanner对象的方法

   + nextByte() 读取byte类型的整数
   + nextShort() 读取short类型的整数
   + nextInt() 读取一个int类型的整数
   + nextLong() 读取一个long类型的整数
   + nextFloat() 读取一个float类型的数
   + nextDouble（）读取一个double类型的数

   如果你输入一个不正确范围或类型的数会产生异常。

unix时间戳转换成当前时间

+ 调用System.currentTimeMillis()方法获取1970年1月1日午夜到现在的毫秒数，并存放在totalMilliseconds中
+ 通过将总的毫秒数totalMillseconds除以1000得到总秒数totalSeconds
+ 通过totalSeconds%60得到当前的秒数
+ 通过totalSeconds除以60得到总的分钟数totalMinutes
+ 通过totalMinutes%60得到当前分钟数
+ 通过totalMinutes除以60获得总小时数totalHours
+ 通过totalHours%24得到当前的小时数

假如你希望爱法一个程序，将给定的签署分成呢个较小的货币单位。这个程序要求用户输入一个double型的值。该值是用美元和美分表示的总签署，然后列出dollar（1美元）、quarter(2角5分)、dime（1角）、nickel（5分）和penny（1分）的数目

下面是开发的过程：

1. 提示用户输入是禁止作为总签署，例如11.56
2. 将改签数转换成1分币的个数（例如1156）
3. 通过1分布的个数除以100,求出1美元的个数。通过1分币的个数对100求余，得到剩余1分币的个数
4. 通过1分币的个数除以25,求出2角5分的个数。通过剩余1分币的个数对25求余得到剩余1分币的个数
5. 将剩余个数除以10,求出1角币的个数，通过对剩余个数对10求余，得到剩余个数
6. 将剩余个数除以5,求出5分币的个数。通过对剩余个数对5求余数，得到剩余1分币的个数

产生随机数：Math.random()来获得一个0.0到1.0之间的随机double值。同样（int）Math.random()×10来获得一个0到9之间的随机int值

判定润年：如过某年可以被4整除而不能被100整除，或着能被400整除则是润年。

isLaepyear=(year%4==0&&year%100!=0)||(year%400==0)

+ 字符的比较和测试 ：两个字符可以使用关系操作符进行比较，如同比较两个数字一样。

4. Character类方法

   + isDigit(ch)     如果指定字符是一个数字返回true
   + isLetter(ch )   如果指定字符为字母返回true
   + isLetterOrDigit(ch) 如果指定的字符是字母或数字，返回true
   + isLowerCase(ch )   如果指定字符维小写字母，返回true
   + isUpperCase(ch )   如果指定字符维大写字母，返回true
   + toLowerCase(ch)    返回指定字符的小写形式
   + toUpperCase(ch)     返回指定字符的大写形式

   java.util.Scanner.next() 读取以空白字符结束的字符串（即" ",'\t','\f','\r'或'\n'），可以使用nextLine()方法读取一整行文本。为避免输入错误，不要在nextByte(),nextInt(),nextLong().nextDouble()和next（）之后使用nextLine().

+ 将十六进制转换成十进制数

```java
import java.util.Scanner;
public class HexDigit2Dec{
  public x=static void main(String[] args){
    Scanner input=new Scanner(System.in);
    System.out.print("enter a hex digit");
    String hexString=input.nextLine();
    if(hexString.length()!=1){
      System.out.println("you must enter on character");
      System.exit(1);
    }
    char ch=Character.toupperCase(hexString.charAt(0));
    if(ch<='F'&&ch>='A'){
      int value=ch-'A'+10;
      System.out.println("the decimal value for hex digit"+ch+"is "+value);
    }
    else if(Character.isDigit(ch)){
       System.out.println("the decimal value for hex digit"+ch+"is "+ch);
    }else{
      System.out.println(ch+" is an invalid input");
    }
  }
}
```

+ 十进制转换成十六进制

```java
import java.util.Scanner;
public class Dec2Hex{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    int decimal=input.nextInt();
    String hex="";
    while(decimal!=0){
      int hexvalue=decimal%16;
      char hexDigit=(hexvalue<=9&&hexvalue>=0) ? (cahr)(hexvalue+'0'):(char)(hexvalue-10+'A');
      hex=hexDigit+hex;
      decimal=decimal/16;
    }
    System.out.println("the hex number is"+hex);
  }
}
```

+ 判断回文

```java
import java.util.Scanner;
public class Palindrome{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    String s=input.nextLine();
    int low=0;
    int high=s.length()-1;
    boolean isPalindrome=true;
    while(low<high){
      if(s.charAt(low)!=s.charAt(high)){
        isPalindrome=false;
        break;
      }
      low++;
      high--;
    }
    if(isPalindrome)
      System.out.println(s+"is a palindrome");
    else 
    System.out.println(s+" is not a palindrome");
  }
}
```

+ 复制数组有三种方法：

1. 使用循环语句逐个地赋值数组元素

2. 使用System类中静态方法arraycopy

   ​

3. 使用clone方法复制数组。

+ 将数组传递给方法：当将一个数组传递给方法时，数组的引用被传递方法
+ 从方法中返回数组

```java
public static int[] reverse(int[] list){
  int[] result=new int[list.length];
  for(int i=0,j=result.length-1;i<list.length;i++,j--){
    result[j]=list[i];
  }
  return result;
}
```

+ 统计每个字母出现的次数

```java
public class CountLettersInArray {
 /** Main method */
public static void main(String[]args){
 // Declare and create an array
 char[] chars = createArray();

 // Display the array
 System.out.println("The lowercase letters are:");
 displayArray(chars);

 // Count the occurrences of each letter
 int[] counts =countLetters(chars);

 // Display counts
 System.out.println();
 System.out.println("The occurrences of each letter are:'*);
 displayCounts(counts);
 }

 /** Create an array of characters */
 public static char[] createArray() {
 // Declare an array of characters and create it
 char[] chars = new char[100];

 // Create lowercase letters randomly and assign
 // Create lowercase letters randomly and assign
// them to the array
 for(int i = 0; i < chars.length; i++)
 chars[i]= RandomCharacter.getRandomLowerCaseLetter();

 // Return the array
 return chars;
 }

 /** Display the array of characters */
 public static void displayArray(char[] chars){
 // Display the characters in the array 20 on each line
 for(int = 0; i < chars.length; i++){
 if((i + 1)% 20 =* 0)
 System.out.println(chars[i]);
 else
 System.out.print(chars[i]+ "")
 }
 

 /** Count the occurrences of each letter */
 public static int[] countLetters(char[] chars){
 // Declare and create an array of 26 int
 int[]counts = new int[26];

 // For each lowercase letter in the array, count it
 for(int = 0; i < chars.length; i++)
 counts[chars[i]- 'a']++;//这里需要注意，chars[i]- 'a'实现了字符向整型数字转换
 return counts;
 }
  /** Display counts V**/
 public static void displayCounts(int[] counts){
 for(int i=0; i < counts.length; i++){
 if((i + 1)%10==0)
    System.out.println(counts[i] (char)(i + 'a'));
else
     System.out.print(counts[i] + " " + (char)(i +'a'+ "");//注意这里(char)(i +'a'+ " ")
     //整型数字向字母转换
}
}
}

```

以上代码中存在字母与整型数字之间的转换。

这里需要注意的的是，字符向数字，数字向字符的转换。

字符转数字：

```
char c='5';
  int x1=c-'0';//字符转数字
  System.out.println("2:字符转数值 "+x1);
```

数值转字符串

```java
int v=123;
  String s1=String.valueOf(v);
  String s2=Integer.toString(v);
  System.out.println("3:数值转字符串/字符 "+s1+" "+s2);
```

1）**将字符串转化为整型**；

int i = Integer.parseIn(String str);

int i = Integer.valueOf().intValue();

注：Integer.parseIn 和 Integer.valueOf 不同，前者生成的是整型，而后者是一个对象，所以要通过intValue()来获得对象的值；

字串转成 Double, Float, Long 的方法大同小异.

2) **整型转化为字符串**：

String str = String.valueOf(int i);

String str = Integer.toString(int i);

String str = “” + i ;

注： Double, Float, Long 的方法大同小异.

产生随机字符串的一种方法：

```java
    final String alphabet = "0123456789ABCDE";
    final int N = alphabet.length();

    Random r = new Random();

    for (int i = 0; i < 50; i++) {
        System.out.print(alphabet.charAt(r.nextInt(N)));
    }
```

第二种方法

```
public static char randomSeriesForThreeCharacter() {
    Random r = new Random();
    char random_3_Char = (char) (48 + r.nextInt(47));
    return random_3_Char;
}
```

java.util.Arrays类包含各种各样的静态方法，用于实现数组的排序和查找、数组的比较和填充数组元素，以及返回数组的字符串表示。

+ 多维数组

```java
java.util.Scanner input=new Scanner(System.in);
System.out.println("enter nums");
for(int column=0;row<matrix.length;row++){
  for(int column=0;column>matrix[row].length;column++){
    matrix[row][column]=input.nextInt();
    //matrix[row][column]=(int )(Math.random()*100);
  }
}
```

+ 文件输入和输出

使用Scanner类从文件读取文本数据，使用PrintWriter类向文本文件写入数据。File对象封装了文件或路径的属性，但是它既不包括创建文件的方法，也不包括从/向文件读写数据的方法。为了完成I/O操作，需要使用恰当的java I/O类创建对象。这些对象包括从/向文件读/写数据的方法。文本文件的实质上是存储在磁盘的字符。

java.io.PrintWriter类可用来出那个键一个文件并向文本文件写入数据。首先，必须为一个文本文件创建一个PrintWriter对象。 PrintWriter outputnew PrintWriter(filename);然后，可以体哦啊用PrinterWriter 对象上的print、println和printf方法写入数据。

+ 二进制I/O

文件可以分类为文本或者二进制的。可以使用文本编辑器，进行处理的文件称为文本文件。所有其他文件称为二进制文件。不能使用文本编辑器来读取二进制文件，他们是为程序来读取而设计的。java提供了kudzu实现文件输入/输出的类。这些类可以分为文本I/O类和二进制I/O类。Scanner和PrintWriter是如何从/向文本文件读/写字符串和数字值。

java中处理文本I/O： 使用Scanner类读取文本数据，使用PrintWriter类读写文本数据。

二进制I/O不涉及编码和解码，因此比文本I/O更加高效。

计算机并不区分二进制与文本文件。所有的文件都是以二进制形式来存储的，因此，从本质上讲，所有的文件都是二进制文件。文本I/O建立在二进制I/O的文件之上，它能提供一层抽象。用于字符层次的编码和解码。对于文本I/O而言，编码和解码是自动进行的。

## 排序引论

​      排序是一个常见又重要的任务，因而存在许多排序算法。本章将考虑一些基本排序程序，尽管大部分是针对整数排序的，但给出的java实现可以对任何可比对象进行排序----即任何实现了Comparable接口并定义了compareTo方法的类的对象。

```
编程小提示：
为了使Comparable能用于任意类型，令Comparable<? super T> 代替Comparable<T>
+ 受限通配符
在使用泛型时，通配符 ？ 可以表示任意类，可以使用以下两种方式中的一种来约束或者限制这个通配符。例如，？ super Gizmo 表示Gizmo的任意一个超类。我们就说Gizmo是通配符的下限。类似的，？ extends Gizmo表示Gizmo的任意子类。这里，Gizmo是通配符的上限。
```

### 选择排序

选择排序的基本思想是：每趟在n-i+1(i=1,2,.....,n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。一趟简单选择排序的操作为：通过n-i次关键字间的比较，从n-i+1个记录中选择出关键字最小，并和第i个记录交换。

代码如下：

```java
package test;

public class SelectSort {
public static void main(String[] args){
	int[] nums=new int[]{2,34,6,78,9,0};
	int index=0;
	for(int i=0;i<nums.length;i++){
		//寻找最小的，交换
		int min=nums[i];
		index=i;
		for(int j=i;j<nums.length;j++){
			if(min>nums[j]){
				min=nums[j];
				index=j;
				//System.out.println(index);
			}
		}
		//找到合适的元素，交换
		int temp=nums[i];
		nums[i]=nums[index];
		nums[index]=temp;
	}
	for(int k:nums){
		System.out.print(k+" ");
	}
}
}

```

选择排序的时间复杂度为 $$ O(n^2) $$  ,空间复杂度为$$ O(n) $$ . 

### 插入排序

直接插入排序是一种最简单的排序方法，它的基本操作是将一个记录插入到排号需的有序列表中，从而得到一个新的、记录数增1的有序列表。

代码如下：

```java
public static void insertOrder(int[] a,int start,int end){
		if(start<end){
			insertOrder(a,start,end-1);
			insert(a[end],a,start,end-1);
		}
	}
	public static void insert(int b,int[] a, int start,int end){
		if(b>=a[end]){
			a[end+1]=b;
		}
		else if(start<end){
			a[end+1]=a[end];
			insert(b,a,start,end-1);
		}
		else{//注意这种情况
			a[end+1]=a[end];
			a[end]=b;
		}
	}
```

我们使用递归来实现插入排序，inserOrder(int[] a,int start,int end),我们分两步来实现1. insertOrder(a,start,end-1)，使start到end-1 为有序。 2.insert(a[end],a,int start ,int end).即在排好序的数组插入最后一个数

插入排序时间复杂度为$$ O(n^2) $$ ,

### 链表的插入排序

注：对链表的排序有可能困难，然而插入排序提供了一个合理的方法来完成这个任务。对链表进行表头插入，可以实现链表的有序。