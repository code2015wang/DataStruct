/* 实现自己的pow（x，y） 乘方运算
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double res = 1.0;
        if( n < 0){
            if(x >= 1.0 / Double.MAX_VALUE || x <= -1.0 / Double.MAX_VALUE)
                x = 1.0 / x;
            else
                return Double.MAX_VALUE;
            if(n == Integer.MIN_VALUE){
                res * = x;
                n++;
            }
        }
        n = Math.abs(n);
        boolean isNeg = false;
        if(n % 2 == 1 && x <0){
            isNeg = true;

        }
        x = Math.abs(x);
        while(n > 0){
            if((n&1) == 1){
                if(res > Double.MAX_VALUE / x)
                    return Double.MAX_VALUE;
                res * = x;
            }
            X * = x;
            n = n >> 1;
        }
        return isNeg ? -res : res;
    }
}
