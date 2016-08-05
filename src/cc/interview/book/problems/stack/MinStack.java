package cc.interview.book.problems.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * A Stack Impl that takes O(1) in pop(), push() and min();
 */

public class MinStack<T extends Comparable<T>> extends Stack<T> {
    private Stack<T> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    @Override
    public T push(T elem) {
        super.push(elem);
        if (min() == null)
            minStack.push(elem);
        else if (elem.compareTo(minStack.peek()) < 0)
            minStack.push(elem);

        return elem;
    }

    public T min() {
        if (minStack.empty())
            return null;
        else
            return minStack.peek();
    }

    @Test
    public void test() {
        MinStack<Integer> minStack = new MinStack<>();
        for (int i = 0; i < 100000; i++) {
            minStack.push(i);
        }
        org.junit.Assert.assertEquals(minStack.min(), (Integer) 0);
    }
}