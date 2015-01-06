package String;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 *
 */
public class LengthofLastWord {
	@Test
	public void test(){
		String lofwords = "  ";
		assertEquals(0, lengthOfLastWord(lofwords));
	}
	public int lengthOfLastWord(String s) {
        int lenoflastword = 0;
        
        s = s.trim();
        int length = s.length();
        
        int index = s.lastIndexOf(' ');
        if(index==-1){
        	if(length>0)
        		lenoflastword = length;
        }	
        else{
        	s = s.substring(index+1, s.length());
        	lenoflastword = s.length();
        }
        
        return lenoflastword;
    }	
	
}
