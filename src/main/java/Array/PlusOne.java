package Array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Plus One
 * Non-negative number represented by a array of digits, return the number by plus one to the number
 */
public class PlusOne {
    @Test
    public void test(){
        int [] arr = new int[10];

    }
    @Test
    public void test2(){
        int a[] = new int[]{1,9,9}, b[]=new int[]{2,0,0};
        assertArrayEquals(b, plusOne(a));

    }


    @Test
    public void test3(){
        int a[] = new int[]{9,9}, b[]=new int[]{1,0,0};
        assertArrayEquals(b, plusOne(a));
    }
    public int[] plusOne(int[] digits) {

        int sum = digits[digits.length-1]+1;
        int advance = sum/10;
        digits[digits.length-1] = sum%10;

        for(int i=digits.length-2;i>=0;i--){
            sum = digits[i]+advance;
            digits[i] = sum%10;
            advance = sum/10;
        }

        if(advance==1){
            int res[] = new int[digits.length+1];
            res[0]=1;
            for(int i=0;i<digits.length;i++){
                res[i+1] = digits[i];
            }
            return res;
        }

        return digits;

    }
}
