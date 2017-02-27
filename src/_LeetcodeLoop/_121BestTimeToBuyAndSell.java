package _LeetcodeLoop;

/**
 * Created by epttwxz on 27/02/17.
 */
public class _121BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices!=null && prices.length>0){
            int curmax = 0;
            for(int i=1;i<prices.length;i++){
                curmax = prices[i] - prices[i-1] + curmax> 0? prices[i] - prices[i-1]+curmax: 0;
                max = max>curmax? max: curmax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new _121BestTimeToBuyAndSell().maxProfit(prices));
    }
}
