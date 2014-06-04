package LinearList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum {
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
	static public int[] twoSumSum(int[] numbers, int target) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
	 
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index+1 ;
				result[1] = i+1;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
	 
		return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num ={1,3,4,5};
		int[] num2 ={0,3,4,0};
		Map inputMap = new HashMap();
		for(int i=0;i<num2.length;i++){
			inputMap.put(num2[i], i);
		}
		int target = 9;
		System.out.println(inputMap);
	}

}
