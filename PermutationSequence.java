package LinearList;

public class PermutationSequence {
	// coding scheme k/(n-i)!
	public static String getPermutation(int n, int k) {
		String seq = "";
		for(int i=1;i<=n;i++){
			seq += i;
		}
		
        String res=null;
        
        return res;
    }
	public static int factorial(int n){
		int res=1;
		for(int i=n;i>1;i--){
			res*=i;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq =null;
		for(int i=1;i<=5;i++){
			seq = getPermutation(3,i);
			System.out.println(seq);
		}
	}

}
