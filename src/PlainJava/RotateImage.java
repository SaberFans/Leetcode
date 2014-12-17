package PlainJava;

import java.util.Arrays;

public class RotateImage {
	public static void slowRotate(int[][]matrix){
		if(matrix==null ||matrix.length==0) return;
		int size = matrix.length;
		// save (0,x) row
		int saved[]=new int[size];
		for(int c=0,s=size;c<size/2;c++,s-=2){
			int start = c, end =size-c;
			for(int i=start;i<end;i++){
				saved[i]=matrix[start][i];
			}
			// rotate by by circle
			//1.
			for(int i=start;i<end;i++)
				matrix[start][i]=matrix[size-1-i][start];
			//2.
			for(int i=start;i<end;i++)
				matrix[i][start]=matrix[size-1-start][i];
			//3.
			for(int i=start;i<end;i++)
				matrix[size-1-start][i]=matrix[size-1-i][size-1-start];
			//4.
			for(int i=start;i<end;i++)
				matrix[size-1-i][size-1-start]=saved[size-1-i];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		for(int[] c: matrix)
			System.out.println(Arrays.toString(c));
		slowRotate(matrix);
		for(int[] c: matrix)
			System.out.println(Arrays.toString(c));
	}
}
