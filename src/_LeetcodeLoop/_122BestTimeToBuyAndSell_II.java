package _LeetcodeLoop;

/**
 * Created by epttwxz on 27/02/17.
 */
public class _122BestTimeToBuyAndSell_II {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices!=null && prices.length>0){
            for(int i=1;i<prices.length;i++){
                max += prices[i]-prices[i-1]> 0 ? prices[i]-prices[i-1]: 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int []prices = {1,2,4};
        System.out.println(new _122BestTimeToBuyAndSell_II().maxProfit(prices));
    }
}
