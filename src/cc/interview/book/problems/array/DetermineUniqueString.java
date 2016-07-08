package cc.interview.book.problems.data;


import org.junit.Test;

/**
 * Class for Determine if String has all unique chars.
 * Solution with no additional space allocation.
 */
public class DetermineUniqueString {
    /**
     * Check String has all unique chars by recording
     * the bits. Use Inclusive And & to check if
     * there's overlapping in bits, and aggregate each
     * bit record for each character.
     *
     * @param args input String to evaluate.
     * @return true if string contains all unique chars.
     */
    public boolean isUniqueString(String args) {
        int checker = 0;
        for (int i = 0; i < args.length(); i++) {
            int val = args.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);

        }
        return true;
    }

    @Test
    public void test(){
        org.junit.Assert.assertEquals(true, isUniqueString("abcdefghijklmn"));
        org.junit.Assert.assertEquals(false, isUniqueString("apple"));
    }
    @Test
    public void testEmpty(){
        org.junit.Assert.assertEquals(true, isUniqueString(""));
    }

}
