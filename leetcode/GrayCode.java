/* 灰色代码是一个二进制数字系统，其中两个连续的值只有一位不同。给定代表代码中总位数的非负整数n，打印灰色代码序列。灰色代码序列必须以0开头。如给定 n = 2,返回[0,1,3,2],其灰色代码序列为：
   00-0
   01-1
   11-3
   10-2
*/
public class GrayCode {
    public List<Integer> grayCode(int n){
        List<integer> result = new LinkedList<>();
        for(int i = 0; i < 1<<n; i++) result.add(i ^ i >> 1);
        return result;
    }
}
