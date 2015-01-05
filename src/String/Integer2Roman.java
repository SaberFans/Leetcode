package String;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Convert Roman number to Integer value
 * Maximum input is 3999
 *
 */
public class Integer2Roman {
	 
	static char roman[] ={
		'I',   // 0: 1
		'V',   // 1: 5
		'X',   // 2: 10
		'L',   // 3: 50
		'C',   // 4: 100
		'D',   // 5: 500
		'M'    // 6: 1000
		
	}; 
	

	/**
	 * @param num
	 * @return Roman number of that character
	 */
	public String intToRoman(int num) {
		 
		String romanStr = new String();

		int scale = 1000;
 
		for(int i=6;i>=0;i-=2){
			int val = num/scale;
			if(val!=0){

				if(val<=3){
					for(int index =0;index<val;index++)
						romanStr = romanStr.concat(Character.toString(roman[i]));
				}
				else if(val==4){
					romanStr = romanStr.concat(Character.toString(roman[i]));
					romanStr = romanStr.concat(Character.toString(roman[i+1]));
				}
				else if(val==5){
					romanStr = romanStr.concat(Character.toString(roman[i+1]));
				}
				else if(val<=8){
					romanStr = romanStr.concat(Character.toString(roman[i+1]));
					for(int index =0;index<val-5;index++)
						romanStr = romanStr.concat(Character.toString(roman[i]));
				}
				else{
					romanStr = romanStr.concat(Character.toString(roman[i]));
					romanStr = romanStr.concat(Character.toString(roman[i+2]));
				}
				num = num%scale;
				
			}
			
			scale = scale/10;
		}
		 
		
		return romanStr;
	}
	
	@Test
	public void test4(){
		String romstr = "IV";
		assertEquals(romstr, intToRoman(4));
	}
	
	@Test
	public void test5(){
		String romstr = "V";
		assertEquals(romstr, intToRoman(5));
	}
	
	@Test
	public void test6(){
		String romstr = "VI";
		assertEquals(romstr, intToRoman(6));
	}
	
	@Test
	public void test7(){
		String romstr = "VII";
		assertEquals(romstr, intToRoman(7));
	}
	
	@Test
	public void test8(){
		String romstr = "VIII";
		assertEquals(romstr, intToRoman(8));
	}
	
	@Test
	public void test9(){
		String romstr = "IX";
		assertEquals(romstr, intToRoman(9));
	}
	
	@Test
	public void test10(){
		String romstr = "X";
		assertEquals(romstr, intToRoman(10));
	}
	
}
