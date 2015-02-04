package Array;

/**
 * SingleNumber get the number appears only once.
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        int x=0;

        for(int a: A){
            x = x ^ a;
        }

        return x;
    }
}
