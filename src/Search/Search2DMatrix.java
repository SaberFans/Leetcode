package Search;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Binary Search a value in a matrix,
 * which has the values sorted from left to right.
 * And the left-most value of each line is greater than or equal to the last value of last line.
 *
 *  Binary Search
 */
public class Search2DMatrix {

    @Test
    public void test(){
        for(int i=0;i<5;i++){
            System.out.println(i);
            if(i==3){
                break;
            }
        }

    }

    @Test
    public void validResult(){
        assertEquals(true, searchMatrix(new int[][]{{1,2,3},{4,5,6},{8,9,10}}, 10));

    }

    @Test
    public void validResult2(){
        assertEquals(true, searchMatrix(new int[][]{{1,2,3}}, 2));

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int h = matrix.length;
        int w = matrix[0].length;
        boolean found = false;
        int vindex = 0;
        for(int upper=0, lower= h-1;upper<=lower;){
            vindex = upper + (lower-upper)/2;

            if(matrix[vindex][w-1]>target){

                if(target>=matrix[vindex][0]){
                    found= true;

                    break;
                }
                lower = vindex-1;

            }
            else if(matrix[vindex][w-1]<target){
                upper = vindex+1;
            }
            else {
                return true;
            }
        }
        if(found){

            if(matrix[vindex][0]==target)
                return true;


            for(int upper=0, lower= w-1;upper<=lower;){
                int mid = upper + (lower-upper)/2;
                if(matrix[vindex][mid]>target){
                    lower = mid-1;
                }
                else if(matrix[vindex][mid]<target){
                    upper = mid+1;
                }
                else
                    return true;
            }
        }
        return false;
    }
}
