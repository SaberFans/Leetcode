package LinearList;

public class RemoveDuplicatesFromArray {
	// RemoveDuplicates1
	static int removeDup1(int A[]){
		int n = A.length;
		int length = 0;
		for(int i=0; i<n;){
			int temp = A[i];
			length++;
			for(;i<n;i++)
				if(A[i]!=temp)
				{
					A[length]=A[i];
					break;
				}
		}
		return length;
	}
	// Version 2
	static int removeDup1_1(int A[]){
		int n = A.length;
        if(n==0) return 0;
        int length =0;
		for(int i=0;i<n;i++){
			if(A[length]!=A[i])
				A[++length]=A[i];
		}
		return length+1;
	}
	
	static public void main(String[]args){
		// Remove Duplicates 1
		int A[] ={1,1,1,2,2,2,3,4,5,6,7,7,7,8,9};
		int length = removeDup1_1(A);
		for(int i=0;i<length;i++)
			System.out.println(A[i]);
		
	}
}
