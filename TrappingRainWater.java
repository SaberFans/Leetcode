package LinearList;

public class TrappingRainWater {
	static int trap(int[]A,int n){
		int sum=0;
		int left[]=new int[n];
		int right[]=new int[n];
		if(n>0){
			left[0]=A[0];
			right[n-1]=A[n-1];
		}
		for(int i=1;i<n;i++){
			left[i] = Math.max(left[i-1], A[i]);
			right[n-i-1] = Math.max(A[n-i-1], right[n-i]);
		}
		
		for(int i=0;i<n;i++){
			sum +=Math.min(left[i], right[i])-A[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]A={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A,A.length));
	}
}
