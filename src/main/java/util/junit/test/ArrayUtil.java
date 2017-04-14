package util.junit.test;


public class ArrayUtil {
	static public int[] toArray(Integer[]input){
		if(input==null || input.length==0)
			return new int[]{};
		int[] unboxed = new int[input.length];
		
		int i=0;
		for(Integer integer:input){
			unboxed[i] = integer;
			i++;
		}
		return unboxed;
		
	}
}
