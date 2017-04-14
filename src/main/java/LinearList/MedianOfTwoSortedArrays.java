package LinearList;

public class MedianOfTwoSortedArrays {

	static double findMedianOfTwoSortedArrays(int[]A,int m,int[]B,int n){
		int size = m+n;
		if((size & 0x1)==1){
			return find_kth(A, 0, m, B, 0, n, size/2+1);
		}
		else{
			return (find_kth(A, 0, m, B, 0, n, size/2)+
					find_kth(A, 0, m, B, 0, n, size/2+1))/2.0;
		}
		
	}
	static int find_kth(int []A,int first1,int m, int[]B,int first2, int n, int k){
		if(m>n) return find_kth(B,first2,n,A,first1,m,k);
		if(m==0) return B[first2+k-1];
		if(k==1) return Math.min(A[first1],B[first2]);
		
		int midA = Math.min(m, k/2);
		int midB = k-midA;
		if(A[first1+midA-1]>B[first2+midB-1])
			return find_kth(A,first1,m,B,first2+midB,n-midB,k-midB);
		else if(A[first1+midA-1]<B[first2+midB-1])
			return find_kth(A,first1+midA,m-midA,B,first2,n,k-midA);
		else
			return A[first1+midA-1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]={1,2,5};
		int B[]={2,3,4};
		System.out.println(findMedianOfTwoSortedArrays(A, 3, B, 3));
	}

}
