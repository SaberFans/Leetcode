package _LeetcodeLoop;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by epttwxz on Apr 19, 2017
 */
public class _121BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int curMax = 0;
		int fnMax = 0;
		if(prices!=null && prices.length>=2){
			for(int i=1;i<prices.length;i++){
				curMax = Math.max(0, prices[i]-prices[i-1]+curMax);
				fnMax = Math.max(curMax, fnMax);
			}
		}
		return fnMax;
	}
	@Test
	public void test(){
		int prices[] = {1, 2, 3, 4, 3, 7};
		Assert.assertEquals(6, new _121BestTimeToBuyAndSellStock().maxProfit(prices));
	}
	@Test
	public void test2(){
		int prices[] = {1, 2, 3, 0, 3, 7};
		Assert.assertEquals(7, new _121BestTimeToBuyAndSellStock().maxProfit(prices));
	}
}
