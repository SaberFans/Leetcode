package practice;

/**
 * Created by epttwxz on 22/11/16.
 */
public class CodePractice {

    public void getMedian(int[] arrA, int[] arrB){
        // boundary check
        int lengthA = 0, lengthB = 0;
        if(arrA!=null)
            lengthA = arrA.length;
        if(arrB!=null)
            lengthB = arrB.length;
        if(lengthA==0&&lengthB==0)
            return;
        else if(lengthA==0){
            System.out.println(arrB[lengthB/2]);
        }
        else if(lengthB==0){
            System.out.println(arrA[lengthA/2]);
        }
        // merge two sorted array step
        else{
            int medianIndex = lengthA+ (lengthB-lengthA)/2;
            int setoffIndex = 0;
            int median = 0;
            int aI = 0, bI = 0;
            while(setoffIndex<medianIndex){

                if(aI<lengthA && bI<lengthB) {
                    if (arrA[aI] < arrB[bI]) {
                        median = arrA[aI++];
                    } else {
                        median = arrB[bI++];
                    }
                }
                else if(bI<lengthB){
                    median = arrB[bI++];
                }
                else{
                    median = arrA[aI++];
                }
                setoffIndex++;
            }
            System.out.println(median);
        }

        return;


    }
    public static void main(String[]args){
        new CodePractice().getMedian(new int[]{-1,0,1}, new int[]{2,4,5});
    }

}
