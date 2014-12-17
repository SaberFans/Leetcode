package LinearList;

public class PermutationSequence {
	// coding scheme A(i) = k/(n-i)!
	public static String getPermutation(int n, int k) {
		int seq[]=new int[n];
		int seqcopy[]=new int[n];
		for(int i=1;i<=n;i++){
			//seq[i-1] = i;
			seqcopy[i-1] = i;
		}
		k--;
		int base = factorial(n-1);
		for(int i=1;i<n;i++){
			int index = k/factorial(n-i);
			
			seq[i-1]=seqcopy[index];
			erase(seqcopy,index);
			k=k%base;
			base/=n-i;
		}
		seq[n-1]=seqcopy[0];
		
        String ret="";
        for(int i=0;i<n;i++){
        	ret += seq[i];
        }
        return ret;
    }
	public static void erase(int[]num,int k){
		int t=0;
		for(int i=0;i<num.length;i++){
			if(i!=k)  num[t++]=num[i];
		}
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
		for(int i=1;i<=10;i++){
			seq = getPermutation(6,i);
			System.out.println(seq);
		}
	}

}
