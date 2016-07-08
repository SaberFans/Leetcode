package cc.interview.book.problems.data;

import org.junit.Test;

/**
 * Replace spaces in String with encodes '%20'.
 */
public class ReplaceSpacesWithEncodes {
    public String encodeSpaces(String sourceString){
        String result = null;
        if(sourceString==null)
            return result;
        int space_count = 0;
        for(char c: sourceString.toCharArray()){
            if(c==' ')  space_count++;
        }
        int new_length = sourceString.length() + space_count*2;
        char[] encodedString = new char[new_length];
        int encodedString_index = new_length-1;

        for(int i=sourceString.length()-1;i>=0;i--){
            if(sourceString.charAt(i)==' '){
                encodedString[encodedString_index] = '0';
                encodedString[encodedString_index-1] = '2';
                encodedString[encodedString_index-2] = '%';
                encodedString_index-=3;
            }
            else{
                encodedString[encodedString_index--] = sourceString.charAt(i);
            }
        }

        return new String(encodedString);
    }
    @Test
    public void testStringNoSpaces(){
        String input = "hello%20buye";
        org.junit.Assert.assertEquals(input, this.encodeSpaces(input));
    }
    @Test
    public void testStringAllSpaces(){
        String input = "   ";
        org.junit.Assert.assertEquals(input.replaceAll(" ", "%20"), this.encodeSpaces(input));
    }
    @Test
    public void testStringHasSpaces(){
        String input = "hello Mike";
        org.junit.Assert.assertEquals(input.replaceAll(" ", "%20"), this.encodeSpaces(input));
    }
    @Test
    public void testNullString(){
        String input = null;
        org.junit.Assert.assertEquals(null, this.encodeSpaces(input));

    }

    @Test
    public void testEmptyString(){
        String input = "";
        org.junit.Assert.assertEquals("", this.encodeSpaces(input));

    }

    public static void main(String[] args) {

    }
}
