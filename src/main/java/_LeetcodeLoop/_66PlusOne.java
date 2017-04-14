package _LeetcodeLoop;

import java.util.Arrays;

/**
 * Created by epttwxz on 24/02/17.
 */
public class _66PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits!=null && digits.length>0) {
            int carry = 1;
            for (int i = digits.length - 1; i >= 0 && carry>0; i--) {
                int sum = carry + digits[i];
                digits[i] = sum % 10;
                carry = sum / 10;
            }
            if (carry != 0) {
                int result[] = new int[digits.length + 1];
                System.arraycopy(digits, 0, result, 1, digits.length);
                result[0] = carry;
                return result;
            }
            return digits;
        }
        return null;
    }
    public int[] plusOneSimple(int[] digits){
        if(digits!=null && digits.length>0){
            for(int i=digits.length-1;i>=0;i--){
                if(digits[i]<9){
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] newdigts = new int[digits.length+1];
            newdigts[0] = 1;
            return newdigts;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _66PlusOne().plusOneSimple(new int[]{9,9,9})));
    }
}
