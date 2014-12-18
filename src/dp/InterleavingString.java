package dp;

public class InterleavingString {
	String a ="abcdef";
	String b = "abghijk";
	// true = ab
	// interleaving string
	public InterleavingString() {
		
	}
	public static void main(String[] args) {
		boolean a = true, b = false;
		System.out.println(a|=b);
	}
	boolean isIterleaving(String a, String b, String check){
		boolean isIterleaving = false;
		for(int checkIndex=0, aIndex =0, bIndex =0; checkIndex<check.length();checkIndex++){
			int maxLenofA = 0;
			int maxLenofB = 0;
			int index = checkIndex;
			
			while(a.charAt(maxLenofA++)==check.charAt(index++));
			while(b.charAt(maxLenofA++)==check.charAt(index++));
			
			 
			
		}
		return isIterleaving;
	}
	
}
