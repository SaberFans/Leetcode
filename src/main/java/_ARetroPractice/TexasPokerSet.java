package _ARetroPractice;

import java.util.*;

import _ARetroPractice.TexasPokerManagement.*;
import org.junit.Test;

/**
 * Created by yang on 27/03/2017.
 */
public class TexasPokerSet implements Comparable{

    private final PokerFaceType facetype;
    private final String[] origin;

    private HashMap<Integer, List<Integer>> numPerFace = new HashMap<>();

    TexasPokerSet(List<Integer> values, String []origin, PokerFaceType facetype) {
        this.facetype = facetype;
        this.origin = origin;
        populateFaceValue(values);
    }

    private int compareValues(TexasPokerSet o) {

        for(int i=4;i>=1;i--){
            List<Integer> cards = numPerFace.get(i);
            List<Integer> ocards = o.numPerFace.get(i);
            if(cards==null) continue;

            for(int j=0;j<cards.size();j++){
                if(cards.get(j) - ocards.get(j)>0)
                    return 1;
                if(cards.get(j) -ocards.get(j)<0)
                    return -1;
            }
        }
        return 0;
    }
    // get the count of occurrence of each card value
    private void populateFaceValue(List<Integer> values){
        int curSum = 1;
        int first = values.get(values.size()-1);
        int firstIndex = values.size()-1;
        while(firstIndex-- >0){
            if(values.get(firstIndex).equals(first)){
                curSum++;
            }
            else {
                if (!numPerFace.containsKey(curSum)) {
                    numPerFace.put(curSum, new ArrayList<Integer>());
                    numPerFace.get(curSum).add(first);
                }
                else numPerFace.get(curSum).add(first);

                first = values.get(firstIndex);
                curSum = 1;
            }
        }
        // append the last card
        if (!numPerFace.containsKey(curSum)) {
            numPerFace.put(curSum, new ArrayList<Integer>());
            numPerFace.get(curSum).add(first);
        }
        else numPerFace.get(curSum).add(first);

    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof TexasPokerSet){
            int diff = this.facetype.getValue() - ((TexasPokerSet) o).facetype.getValue();
            if(diff!=0) return diff;
            return compareValues((TexasPokerSet)o);
        }
        throw new RuntimeException("input "+ o+ " doesn't the type of "+this.getClass());
    }
    public PokerFaceType getFacetype() {
        return facetype;
    }
    @Override
    public String toString() {
        return Arrays.toString(origin) + facetype;
    }
}
