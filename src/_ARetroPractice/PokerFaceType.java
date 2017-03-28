package _ARetroPractice;

/**
 * Created by yang on 28/03/2017.
 */
public enum PokerFaceType {
    HIGHCARD(0),
    ONEPAIR(1),
    TWOPAIRS(2),
    TREEOFAKIND(3),
    STRAIGHT(4),
    FLUSH(5),
    FULLHOUSE(6),
    FOUROFAKIND(7),
    STRAIGHTFLUSH(8);

    private final int value;

    PokerFaceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
