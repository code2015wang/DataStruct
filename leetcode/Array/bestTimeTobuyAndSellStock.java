/*你现在有一个数组，数组的第i个元素是第i天的股票价格。如果你只有一次的卖出机会，设计一个算法，找出你最大收益。例如
input :[7,1,5,3,6,4]
output:5
因为最大的收益是6-1=5,而不是7-1=6（这个不是收益，是亏本）
input :[7,6,5,4,3,2,1]
output:0
因为不能由收益，股票一路下降，因此最大收益为0
 */
public class bestTimeTobuyAndSellStock{
    public static  int maxProfit  (int[] prices){
        if(prices.length==0) return 0;
        int max=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                max=Math.max(max,prices[i]-min);
                    }else{
                min = prices[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] array1=new int[]{7,1,5,3,6,4};
        int[] array2=new int[]{7,6,5,4,3,2,1};
        System.out.println("arry1收益为"+maxProfit(array1));
        System.out.println("array2收益为"+maxProfit(array2));
      }
}
