package _ARetroPractice;

/**
 * Created by yang on 2016/12/3.
 */
public class SortedSearchTest {

    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;
        // find the outmost boundary
        int startIndex = 0;
        int endIndex = sortedArray.length-1;
        while(startIndex<=endIndex){
            int mid = (startIndex+endIndex)/2;
            if(sortedArray[mid]>=lessThan){
                endIndex = mid-1;
            }
            else{
                count+= mid-startIndex+1;
                startIndex = mid+1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearchTest.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}
