package _ARetroPractice;

import java.util.HashSet;
import java.util.List;

import _ARetroPractice.PokerFaceType;

/**
 * Created by epttwxz on Apr 18, 2017
 */
class FaceDetermineHelper {
	
	public static PokerFaceType determineFaceType(HashSet<String> colors, List<Integer> vals, int maxCount){
        HashSet<Integer> uniqVals = new HashSet<>(vals);
        
        int flushOrStraight = 0;
        if(isStraight(vals, uniqVals))
        	flushOrStraight += 1;
        if(isFlush(colors))
        	flushOrStraight += 2;
        
        switch (flushOrStraight) {
			case 3:
				return PokerFaceType.STRAIGHTFLUSH;
			case 2: 
				return PokerFaceType.FLUSH;
			case 1:
				return PokerFaceType.STRAIGHT;
		}
        
        if(isFourOfAKind(maxCount, uniqVals))
            return PokerFaceType.FOUROFAKIND;
        if(isFullHouse(maxCount, uniqVals))
            return PokerFaceType.FULLHOUSE;
        if(isThreeOfAKind(maxCount, uniqVals))
            return PokerFaceType.TREEOFAKIND;
        if(isTwoPairs(maxCount, uniqVals))
            return PokerFaceType.TWOPAIRS;
        if(isOnePair(maxCount, uniqVals))
            return PokerFaceType.ONEPAIR;
        return PokerFaceType.HIGHCARD;
    }
	
	
	private static boolean isFlush( HashSet<String> colors){
        return colors.size()==1;
    }
	
    private static boolean isStraight(List<Integer> vals, HashSet<Integer> uniqVals){
        if(uniqVals.size()==5){
            for(int i=0;i<vals.size()-1;i++){
                if(vals.get(i)-vals.get(i+1)!=-1)
                    return false;
            }
            return true;
        }
        return false;
    }
	
	private static boolean isFourOfAKind(int maxReplicatesNum, HashSet<Integer> uniqVals){
        return uniqVals.size() == 2 && maxReplicatesNum == 4;
    }
	private static boolean isFullHouse(int maxReplicatesNum, HashSet<Integer> uniqVals){
        return uniqVals.size() == 2 && maxReplicatesNum == 3;
    }
	private static boolean isThreeOfAKind(int maxReplicatesNum, HashSet<Integer> uniqVals){
        return uniqVals.size() == 3 && maxReplicatesNum == 3;
    }
	private static boolean isTwoPairs(int maxReplicatesNum, HashSet<Integer> uniqVals){
        return uniqVals.size() == 3 && maxReplicatesNum == 2;
    }
	private static boolean isOnePair(int maxReplicatesNum, HashSet<Integer> uniqVals){
        return uniqVals.size() == 4 && maxReplicatesNum == 2;
    }
//	private static boolean isHighHand(int maxReplicatesNum, HashSet<Integer> uniqVals){
//        return uniqVals.size() == 5 && maxReplicatesNum == 1;
//    }
    
}
