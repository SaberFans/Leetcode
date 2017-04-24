/**
 * Created by epttwxz on Apr 24, 2017
 */
package _LeetcodeLoop;

/**
 * Maximum profits with no limit of transaction numbers.
 * Fees will apply for each transaction.
 * @author epttwxz
 *
 */
public class _XBestTimeToBuyAndSell {
	
	/**
	 * DP solution for dealing with a fixed fee.
	 * @param prices
	 * @param fee
	 * @return maxPt denotes the max profit.
	 */
	public int maxProfit(int[]prices, int fee){
		int maxPt = 0;
		if(prices!=null&&prices.length>=2){
			
			int localMax[] = new int[prices.length];
			int globalMax[] = new int[prices.length];
			
			localMax[1] = prices[1]-prices[0]-fee;
			globalMax[1] = Math.max(globalMax[0], localMax[1]);
			
			for(int i=2; i<prices.length; i++){
				int diff = prices[i]-prices[i-1];
				
				// the prices going down and then up 
				//  a\       /c
				//    \     /    <---- another trade should happen...
				//	   \_b_/    
				//  
				localMax[i] =Math.max(localMax[i-1]+diff, globalMax[i-1]+diff-fee);
				
				// = globalMax[i-1] when there's a loss.
				// = localMax[i] when there's a profit.
				globalMax[i] = Math.max(globalMax[i-1], localMax[i]);
				
			}
			maxPt = globalMax[prices.length-1];
		}
		return maxPt;
	}
}
