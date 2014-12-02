package LinearList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum {
	// Wrong solution: HashMap doesn't allow multiple values for same keys
	static public Map<Integer,Integer> twoSum(int[]num, int target){
		Map<Integer,Integer> ans, input;
		ans= new HashMap<>();
		input = new HashMap<>();
		for(int i=0;i<num.length;i++){
			input.put(num[i], i);
		}
		Iterator<Entry<Integer, Integer>> it = input.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer,Integer> pairs =  it.next();
			int rest = target-pairs.getKey();
			if(input.containsKey(rest)){
				ans.put(pairs.getValue()+1, input.get(rest)+1);
				break;
			}
		}
		return ans;
	}
	// Right solution: With O(N) worst space complexity
	static public int[] twoSumSum(int[] numbers, int target) {
		int res[] = new int[2];
		Map<Integer,Integer> input = new HashMap<>();
		for(int i=0;i<numbers.length;i++){
			
			if(input.containsKey(numbers[i])){
				res[0]= input.get(numbers[i])+1;
				res[1]= i+1;
				break;
			}
			else{
				int rest = target - numbers[i];
				input.put(rest, i);
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num ={1,3,4,5};
		int[] num2 ={0,3,4,0};
		Map inputMap = new HashMap();
		
		System.out.println(Arrays.toString(twoSumSum(num2,0)));
	}

}
