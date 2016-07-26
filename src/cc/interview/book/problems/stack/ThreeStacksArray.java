package cc.interview.book.problems.stack;

import org.junit.Test;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

/**
 * Keep three stacks in one array.
 * FYI. Missing feature like thread-safe...
 */
public class ThreeStacksArray<T> {

    int indexUsed = 0;
    int stackPointer[] = {-1, -1, -1};
    @SuppressWarnings("unchecked")
    StackNode[] stackNodes = (StackNode[]) Array.newInstance(StackNode.class, 30);

    public ThreeStacksArray() {

    }

    @SuppressWarnings("unchecked")
    ThreeStacksArray(int stackSize) {
        if (stackSize > 0) {
            stackNodes = (StackNode[]) Array.newInstance(StackNode.class, stackSize * 3);
            // stackNodes = new StackNode[100]; this will gave 'generic array creation error'
        } else
            throw new InvalidParameterException("stackSize needs to be positive number.");
    }

    private class StackNode {
        int previous;
        T value;

        StackNode(int prev, T val) {
            this.previous = prev;
            this.value = val;
        }
    }

    public void push(int stackNum, T val) {
        if (indexUsed < stackNodes.length) {
            int previous = stackPointer[stackNum];
            stackNodes[indexUsed] = new StackNode(previous, val);
            stackPointer[stackNum] = indexUsed;
            indexUsed++;

        } else
            throw new ArrayIndexOutOfBoundsException("new elem cannot be pushed, stack is full.");
    }

    public T pop(int stackNum) {
        if (indexUsed == 0)
            throw new NoSuchElementException("the stack is empty.");
        int cur = stackPointer[stackNum];
        StackNode target = stackNodes[cur];
        stackPointer[stackNum] = target.previous;
        stackNodes[cur] = null;
        indexUsed--;
        return target.value;
    }

    @Test
    public void testPushPopBasic() {
        ThreeStacksArray<Integer> array = new ThreeStacksArray<>(1);
        array.push(0, 1);
        array.push(1, 2);
        array.push(2, 3);

        for (int i = 0; i < 3; i++) {
            org.junit.Assert.assertEquals((Integer) (i + 1), array.pop(i));
        }
    }
}
