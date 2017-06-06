/* 给定一个整数数组，返回数组中序号如果数组中的两个数满足条件。如[2,7,11,15] ,target = 9,返回[0,1]*/
import java.util.HashMap;
public class twoSum{
    public int[] twosum(int[] nums){
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int send = target - nums[i];
            if(map.containsKey(send)){
                result[0] = map.get(send);
                result[1] = i;
            } else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
/* HashMap 函数如下：
   clear()
   containsKey(object key)
   containsValue(object value)
   get(Object key)
   isEmpty()
   keySet()
   put(k key ,V value)
   remove(Object key)
   size()
   Collection<V> values()
   Set<Map.Entry<K,V>> entrySet()//遍历使用
   //这里我们再次说一下hashmap的遍历
   for(String k :map.keySet()){
   System.out.println(map.get(k))
}
//另一种方法为
Iterator iter = map.entrySet().iterator()
while(iter.hasNext()){
Map.Entry entry = (Map.Entry)iter.next();
key = (String) entry.getKey();
value = (Integer)  entry.getValue();
}
*/
