package cc.interview.book.problems.stack;

import java.util.ArrayList;

/**
 * Set of Stacks, which each stack within has a threshold of
 * amount of element to store.
 */
public class SetofStack<T> {
    private int STACK_CAPACITY = 3;
    private ArrayList<Stack> stacks = new ArrayList<>();

    public SetofStack(int limit) {
        this.STACK_CAPACITY = limit;
    }

    public void push(T val) {
        if (stacks.isEmpty())
            stacks.add(new Stack());
        Stack stack = stacks.get(stacks.size() - 1);
        if (!stack.push(val)) {
            stack = new Stack();
            stack.push(val);
        }
    }

    public T pop() {
        if (!stacks.isEmpty()) {
            T val = stacks.get(stacks.size() - 1).pop();
            if (stacks.get(stacks.size() - 1).size == 0)
                stacks.remove(stacks.size() - 1);
            return val;
        }
        return null;
    }

    class Stack {
        class Node {
            Node above, below;
            T val;

            Node(T val) {
                this.val = val;
            }

            T getValue() {
                return val;
            }
        }

        private int size = 0;
        private Node bottom, top;

        boolean push(T val) {
            if (size > STACK_CAPACITY)
                return false;
            else {
                Node newNode = new Node(val);
                size++;
                if (size == 1)
                    bottom = newNode;
                join(newNode, bottom);
                top = newNode;

                return true;
            }
        }

        void join(Node above, Node below) {

        }

        T pop() {
            Node curTop = top;
            top = top.below;
            size--;
            return curTop.getValue();
        }
    }
}
