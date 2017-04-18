package _ARetroPractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yang on 27/03/2017.
 */
public class TexasPokerManagement {
	public static boolean isValidInput(String []input){
    	String pattern = "[A-D]([1-9]|0[1-9]|1[0-3])";
    	Pattern p = Pattern.compile(pattern);
    	
    	for(String hand: input){
    		Matcher m = p.matcher(hand);
    		if(!m.find())	return false;
    	}
    	return true;
    }
    

    public static TexasPokerSet generatePokerSet(String []input){
    	if(!isValidInput(input))
    		throw new RuntimeException("wrong input type");

        return new TexasPokerSet(input);
    }
    @Test
    public void test() {
        String[] poker1 = new String[]{"A1", "B1", "C1", "D2", "D3"};
        String[] poker2 = new String[]{"A1", "B1", "C1", "D2", "D2"};
        String[] poker3 = new String[]{"A1","B2", "A3", "A4", "A5"};
        String[] poker4 = new String[]{"A1","A10", "A11", "A12", "A13"};
        String[] poker5 = new String[]{"A1","A10", "B11", "A12", "A13"};
        String[] poker6 = new String[]{"A1","A10", "A11", "A10", "A1"};

        Assert.assertTrue(TexasPokerManagement.generatePokerSet(poker1).getFacetype() == PokerFaceType.TREEOFAKIND);
        Assert.assertTrue(TexasPokerManagement.generatePokerSet(poker2).getFacetype() == PokerFaceType.FULLHOUSE);
        Assert.assertTrue(TexasPokerManagement.generatePokerSet(poker3).getFacetype() == PokerFaceType.HIGHCARD);
        Assert.assertTrue(TexasPokerManagement.generatePokerSet(poker4).getFacetype() == PokerFaceType.STRAIGHTFLUSH);
        Assert.assertTrue(TexasPokerManagement.generatePokerSet(poker5).getFacetype() == PokerFaceType.STRAIGHT);
        Assert.assertTrue(TexasPokerManagement.generatePokerSet(poker6).getFacetype() == PokerFaceType.FLUSH);

        List<TexasPokerSet> pokersetlit = new ArrayList<>();
        pokersetlit.add(TexasPokerManagement.generatePokerSet(poker1));
        pokersetlit.add(TexasPokerManagement.generatePokerSet(poker2));
        pokersetlit.add(TexasPokerManagement.generatePokerSet(poker3));
        pokersetlit.add(TexasPokerManagement.generatePokerSet(poker4));
        pokersetlit.add(TexasPokerManagement.generatePokerSet(poker5));
        pokersetlit.add(TexasPokerManagement.generatePokerSet(poker6));

        Collections.sort(pokersetlit);

        System.out.println(pokersetlit);

    }


}
