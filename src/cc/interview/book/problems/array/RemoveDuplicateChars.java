package cc.interview.book.problems.array;

import org.junit.Test;

/**
 * Remove Duplicates chars for a given String.
 * Solutions uses no extra buffer.
 */
public class RemoveDuplicateChars {
    public int removeDuplicates(char[] input) {
        if (input == null) {
            return 0;
        }
        int tail = 1;
        if(input.length<2)
            return tail;

        for (int i = 1; i < input.length; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (input[j] == input[i]) break;
            }
            if (tail == j) {
                input[tail] = input[i];
                tail++;
            }
        }
        return tail;

    }

    @Test
    /**
     * String does not contain any duplicates.
     */
    public void testNonDuplicates() {
        char[] input = new char[]{'a', 'b', 'c'};

        int length = removeDuplicates(input);

        org.junit.Assert.assertEquals("abc", String.valueOf(input, 0, length));
        org.junit.Assert.assertEquals(3, length);
    }

    /**
     * String contains all duplicates.
     */
    @Test
    public void testAllDuplicates() {
        char[] input = new char[]{'a', 'a', 'a'};

        int length = removeDuplicates(input);
        org.junit.Assert.assertEquals("a", String.valueOf(input, 0, length));
        org.junit.Assert.assertEquals(1, length);
    }

    @Test
    public void testNullString(){
        char[] input = null;

        int length = removeDuplicates(input);
        org.junit.Assert.assertEquals(null, input);
        org.junit.Assert.assertEquals(0, length);
    }

    @Test
    public void testContinuousDuplicates(){
        char[] input = {'a', 'a','a','b','b','b','b'};

        int length = removeDuplicates(input);
        org.junit.Assert.assertEquals("ab", String.valueOf(input, 0, length));
        org.junit.Assert.assertEquals(2, length);
    }

    @Test
    public void testNonContinuousDuplicates(){
        char[] input = {'a', 'a','a','b','a','a','b','a'};

        int length = removeDuplicates(input);
        org.junit.Assert.assertEquals("ab", String.valueOf(input, 0, length));
        org.junit.Assert.assertEquals(2, length);
    }

    public static void main(String[] args) {
        char[ ]input = {'h','e','l','l','o'};
        System.out.println(input);
        char zero = '\u0000';

        System.out.println(zero);
    }
}
