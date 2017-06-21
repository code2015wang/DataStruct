/* 给定一个字符串数组，把具有相同字母的字符串组合在一起。如数组["aet","tea","tan","ate","ate","nat","bat"]
   返回
   [
   ["ate","eat","tea"],
   ["nat","tan"],
   ["bat"]
]
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
public class GroupAnagrams {
    public static ArrayList<List<String>> groupAnagrams (String[] strs){
        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String,List<String>> map = new HashMap<String , List<String>>();
        for(String s : strs) {
            char[] s_char = s.toCharArray();

            Arrays.sort(s_char);
            String keyStr = String.valueOf(s_char);
            if(! map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        ArrayList<List<String>> res = new ArrayList<>();
        for(String k : map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }
    public static void main(String[] args){
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<List<String>> list = groupAnagrams(str);
        for(int i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
/*
  String 类中提供了将基本类型数据转换成String的静态方法也就是 String.valueOf()这个参数多态方法
  String.valueOf(boolean b) : 将boolean变量转换成字符串
  String.valueOf(char c): 将char变量转换成字符串
  String.valueOf(char[] data): 将char数组转换成字符串
  String.valueOf(Char[] data,int offset ,int conut ) : 将char数组中由data[offset] 开始count个元素转换成字符串
  String.valueOf(double d) : 将double变量转换成字符串
  String.valueOf(float f) :将float变量转换成字符串
  String.valueOf(int i) : 将int变量转换成字符串
  String.valueOf(long l) : 将long变量转换成字符串
  String.valueOf(Object obj) : 将Object变量转换成字符串
java Arrays类进行数组排序
java api 对Arrays类的说明是：此类包含操作数组（比如排序和搜索）的各种方法。
1. 对基本数据类型的排序
Arrays类中的sort（）使用的是经过调优的快速排序法
比如int[],double[],char[]等基本数据类型，Arrays只提供了默认的升序排列，没有提供相应的降序排列方法
要对基本数组进行降序排序，需要将这些数组转化为对应的封装类数组，如Integer[],Double[],Character[]等，对这些数组进行排序。
函数原型 static void sort(int[] a) 对指定的int型数组按数字升序排序
static void sort(int[] a, int form ,int to)对指定的数组分为进行升序排序
2. 对符合数据类型的数据进行排序
函数原型
public static<T> void sort(T[] a, Comparator c) 根据指定比较其产生的顺序对指定对象进行排序
public static<T> void sort(T[] a, int from ,int to ,Comparator c) 根据指定的比较器产生的数序对指定数组的指定范围进行排序。
Comparator 是一个接口，若一个类要实现Comparator接口，它一定要实现compare（T o1 ，T o2）,但可以不实现equal(Object obj)函数。
Comparable 接口只提供了int ComparaTo（T  o）方法。
*/
