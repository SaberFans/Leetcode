package cc.interview.book.problems.data;

import org.junit.Test;

/**
 * Decide two String are anagrams or not.
 */
public class DecideAnagram {
    /**
     * Check two strings are anagrams which is qualified by having
     * exact same amount of some characters, and the sum of
     * those characters are also same.
     *
     * @param str1 target string 1.
     * @param str2 target string 2.
     * @return
     */
    public boolean checkAnagram(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.length() != str2.length())
            return false;

        int occurrences[] = new int[256];

        int unique_char_number = 0;

        for (char c : str1.toCharArray()) {
            if (occurrences[c]++ == 0) unique_char_number++;
        }
        int matched_unique_char_num = 0;
        for (int i = 0; i < str2.length(); i++) {
            int ch_val = str2.charAt(i);
            if (occurrences[ch_val] == 0) return false;
            occurrences[ch_val]--;

            if (occurrences[ch_val] == 0) {
                matched_unique_char_num++;
                if (matched_unique_char_num == unique_char_number) {
                    return i == str2.length() - 1;
                }
            }
        }
        return true;

    }

    @Test
    public void testValidate() {
        String input1 = "who is my favourite";
        String input2 = "a foursome whit ivy";
        org.junit.Assert.assertTrue(checkAnagram(input1, input2));
    }
}
