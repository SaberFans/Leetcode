package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import util.junit.test.ArrayUtil;

/**
 * Give the denomination of coins, develop a method 
 * to pay customer the fewest amount of coins.
 * 
 * Greedy solution has its limitation. The 
 * @author epttwxz
 *
 */
public class CoinChange {
	// Consider American coins: 1penny, 5nickle, 10dime, 25 quarter
	int[] coinSet = {25, 10, 5, 1};
	
	int[] greedyCashier(int change){
		ArrayList<Integer> changeSet = new ArrayList<>();
		
		int left = change;
		while(left>0){
			boolean foundChange = false;
			for(int i=0;i<coinSet.length;i++){
				if(left>=coinSet[i]){
					changeSet.add(coinSet[i]);
					left -= coinSet[i];
					foundChange = true;
					break;
				}
				
			}
			if(!foundChange){
				System.out.println("change no available.");
				return null;
			}
		}
		
		return ArrayUtil.toArray(changeSet.toArray(new Integer[1]));
	}
	@Test
	public void testCoinChange() throws Exception {
		System.out.println(Arrays.toString(greedyCashier(50)));
	}
	
}
