package _ARetroPractice;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by yang on 27/03/2017.
 */
public class TexasPokerManagement {

    // used to determine four same or three of the same
    private static int getMaxSumOfSameElements(List collections){
        int maxReplicatesNum = 1;
        int curNum = 1;
        for(int i=1;i<collections.size();i++){
            if(collections.get(i).equals(collections.get(i-1))) {
                curNum++;
                maxReplicatesNum = Math.max(maxReplicatesNum, curNum);
            }
            else
                curNum = 1;
        }
        return maxReplicatesNum;
    }
    public static List<Integer> convertValues(String []faces){
        List<Integer>  vals = new ArrayList<>();
        for(String i: faces){
            int val = Integer.parseInt(i.substring(1));
            val = val==1? 14:val;
            vals.add(val);
        }
        Collections.sort(vals);
        return vals;
    }
    public static HashSet<String> convertColors(String []faces){
        HashSet<String> colors = new HashSet<>();
        for(String face:faces){
            colors.add(face.substring(0,1));
        }
        return colors;
    }
    public static boolean isFlush( HashSet<String> colors){
        return colors.size()==1;
    }
    public static boolean isStraight(List<Integer> vals, HashSet<Integer> uniqVals){
        if(uniqVals.size()==5){
            for(int i=0;i<vals.size()-1;i++){
                if(vals.get(i)-vals.get(i+1)!=-1)
                    return false;
            }
            return true;
        }
        return false;
    }
    public static boolean isFourOfAKind(List<Integer> vals, HashSet<Integer> uniqVals){
        int maxReplicatesNum = getMaxSumOfSameElements(vals);
        return uniqVals.size() == 2 && maxReplicatesNum == 4;
    }
    public static boolean isFullHouse(List<Integer> vals, HashSet<Integer> uniqVals){
        int maxReplicatesNum = getMaxSumOfSameElements(vals);
        return uniqVals.size() == 2 && maxReplicatesNum == 3;
    }
    public static boolean isThreeOfAKind(List<Integer> vals, HashSet<Integer> uniqVals){
        int maxReplicatesNum = getMaxSumOfSameElements(vals);
        return uniqVals.size() == 3 && maxReplicatesNum == 3;
    }
    public static boolean isTwoPairs(List<Integer> vals, HashSet<Integer> uniqVals){
        int maxReplicatesNum = getMaxSumOfSameElements(vals);
        return uniqVals.size() == 3 && maxReplicatesNum == 2;
    }
    public static boolean isOnePair(List<Integer> vals, HashSet<Integer> uniqVals){
        int maxReplicatesNum = getMaxSumOfSameElements(vals);
        return uniqVals.size() == 4 && maxReplicatesNum == 2;
    }
    public static boolean isHighHand(List<Integer> vals, HashSet<Integer> uniqVals){
        int maxReplicatesNum = getMaxSumOfSameElements(vals);
        return uniqVals.size() == 5 && maxReplicatesNum == 1;
    }
    private static PokerFaceType determineFaceType(String []input){
        HashSet<String> colors = convertColors(input);
        List<Integer> vals = convertValues(input);
        HashSet<Integer> uniqVals = new HashSet<>(vals);

        if(isStraight(vals, uniqVals)&&isFlush(colors))
            return  PokerFaceType.STRAIGHTFLUSH;
        if(isFourOfAKind(vals, uniqVals))
            return PokerFaceType.FOUROFAKIND;
        if(isFullHouse(vals, uniqVals))
            return PokerFaceType.FULLHOUSE;
        if(isFlush(colors))
            return PokerFaceType.FLUSH;
        if(isStraight(vals, uniqVals))
            return  PokerFaceType.STRAIGHT;
        if(isThreeOfAKind(vals, uniqVals))
            return PokerFaceType.TREEOFAKIND;
        if(isTwoPairs(vals, uniqVals))
            return PokerFaceType.TWOPAIRS;
        if(isOnePair(vals, uniqVals))
            return PokerFaceType.ONEPAIR;
        return PokerFaceType.HIGHCARD;
    }

    public static TexasPokerSet generatePokerSet(String []input){
        PokerFaceType faceType = determineFaceType(input);
        return new TexasPokerSet(convertValues(input), input, faceType);
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
