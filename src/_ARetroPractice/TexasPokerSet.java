package _ARetroPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import _ARetroPractice.TexasPokerManagement.*;
/**
 * Created by yang on 27/03/2017.
 */
public class TexasPokerSet implements Comparable{
    private PokerFaceType facetype;
    private List<Integer> values;
    private String[] origin;

    TexasPokerSet(List<Integer> values, String []origin, PokerFaceType facetype) {
        this.facetype = facetype;
        this.values = values;
        this.origin = origin;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(origin) + facetype;
    }
}
