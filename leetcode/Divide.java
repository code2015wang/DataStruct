/* 计算两整数相除，不能使用除法、乘法和取余运算,如果溢出返回MAX_INT*/
public class Divide {
    public int divide (int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if(ldivisor == 0) return Integer.MAX_VALUE;
        if((ldividend == 0) || (ldividend < ldivisor)) return 0;
        long lans = ldivide(ldividend,ldivisor);
        int ans = 0;
        if(ans > Integer.MAX_VALUE) {
            ans = (sign ==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            ans = sign * lans;
        }
        return ans ;
    }
    public  long ldivide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor ) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while((sum + sum ) <= ldividend){
            sum + = sum;
            multiple + = multiple;
        }
        return multiple + ldivide(ldividend -sum ,ldivisor);
    }
    /*注意这里的while循环*/
}
