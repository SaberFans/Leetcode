package LinearList;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num) {
        int max = 0;
        Map<Integer,Boolean> numbers = new HashMap<>();
        for(int i:num)
        	numbers.put(i, false);
        for(int i:num){
        	if(numbers.get(i)==true)	
        		continue;

        	int length =1;
        	for(int start=i+1;numbers.containsKey(start);start++){
        		numbers.put(start, true);
        		length++;
        	}
        	for(int start=i-1;numbers.containsKey(start);start--){
        		numbers.put(start, true);
        		length++;
        	}
        	max = Math.max(max, length);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A={1,2,3,9,8,7,6,5,4};
		System.out.println(longestConsecutive(A));
		
	}

}
