package _ARetroPractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;

/**
 * Created by yang on 2016/12/3.
 */
public class TrainComposition {
    private Deque<Integer> deque = new ArrayDeque<>();
    public void attachWagonFromLeft(int wagonId) {
        deque.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        deque.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return deque.removeFirst();
    }

    public int detachWagonFromRight() {
        return deque.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}
