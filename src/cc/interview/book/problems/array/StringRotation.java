package cc.interview.book.problems.data;

import org.junit.Test;

/**
 * Check two strings whether they are rotated by each other.
 */
public class StringRotation {

    public boolean isSubstring(String str1, String str2){
        return str1.contains(str2);
    }

    /**
     * Check if two strings are rotated.
     * Concatenate rotated string by itself, then
     * as it's rotated the concatenate string should contain
     * the original one.
     * ABC   <-> BCA
     * BCA + BCA >> ABC
     * @param input1
     * @param input2
     * @return
     */
    public boolean isRotated(String input1, String input2){
        if(input1==null|| input2==null)
           return false;
        if(input1.length()!=input2.length())
            return false;
        String concate_str = input2+input2;
        return isSubstring(concate_str, input1);

    }

    @Test
    public void testSameString(){
        String str1 = "abc";
        String str2 = "abc";
        org.junit.Assert.assertTrue(isRotated(str1, str2));
    }
    @Test
    public void testRotated(){
        String str1 = "abc";
        String str2 = "bca";
        org.junit.Assert.assertTrue(isRotated(str1, str2));
    }

    @Test
    public void testNonRotated(){
        String str1 = "abcabc";
        String str2 = "abccba";
        org.junit.Assert.assertFalse(isRotated(str1, str2));
    }

}
