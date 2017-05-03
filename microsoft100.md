   本部分是编程之法：面试和算法心得的读书笔记。本书以微软100题为基础。

# 第一章

> 本章重点介绍6个经典的字符串问题，分别是旋转字符串、字符串包含、字符串转换成整数、回文判断、最长回文子串、字符串全排列等问题。读完本章你会发现好的思路都是在充分考虑到问题特征的前提下，或巧用合适的数据结构，或选择合适的算法降低时间复杂度，或选用效率高更高的算法。

## 旋转字符串

> 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”的前两个字符‘a'和’b‘移动到字符串的尾部，使得原来字符串变成字符串’cdefab。请写一函数完成次功能，要求对长度为n的字符串操作的时间复杂度为O(n),空间复杂度为O(1).

首先我们给出一个三步反转的方法，但时空复杂度不符合要求。我们第一步：反转[0,m-1],第二步反转[m,n-1],最后反转整个字符串。由于使用java语言，java的string不存在resever函数，故我们使用stringBuffer.

代码如下：

```java
public class reseverString{
    public static String resever(String str,int n){
        String first=str.substring(0,n);//注意substring函数，便于包括n,因此这里不需要-1
        String sencond=str.substring(n,str.length());
        StringBuffer firstBuffer=new StringBuffer(first).reverse();
        StringBuffer sencondBuffer=new StringBuffer(sencond).reverse();
        StringBuffer temp=firstBuffer.append(sencondBuffer);
        return temp.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(resever("abcdef",2));
    }
}
```

若想时空复杂度符合要求，我们需要自己来写reverse函数。我们可以把resever函数定义为resever(String str, int start,int end)

代码如下：

```java
public class reseverString{
    public static String resever(String str,int n){
        String first=str.substring(0,n);
        String sencond=str.substring(n,str.length());
        StringBuffer firstBuffer=new StringBuffer(first).reverse();
        StringBuffer sencondBuffer=new StringBuffer(sencond).reverse();
        StringBuffer temp=firstBuffer.append(sencondBuffer);
        return temp.reverse().toString();
    }
    public static void resever(char[] str ,int start ,int end){
        while(start<end){
            char temp=str[start];
            str[start]=str[end];
            str[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        String str="abcdefg";//n还是为2.
        char[] strtemp=str.toCharArray();
        resever(strtemp,0,1);//n-1
        resever(strtemp,2,6);//strtemp.length()-1
        resever(strtemp,0,6);
        StringBuffer strbuffer=new StringBuffer();
        strbuffer.append(strtemp);
        System.out.println(strbuffer);
        System.out.println(resever("abcdef",2));
    }
}
```

todo 链表反转



