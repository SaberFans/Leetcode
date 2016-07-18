package cc.interview.book.problems.linkedlist;

import org.junit.Test;

/**
 * Circular Linked List related questions.
 * A Circular LL in which a node's next points to earlier node.
 */
public class CircularLinkedList {
    /**
     * Tell if a LL has a node referring back to
     * the previous node which results in a loop
     * in the LL.
     *
     * @param head LL's head node
     * @return true that LL has a loop.
     */
    public boolean determinLoop(Node head) {
        if (head == null)
            return false;
        Node p1 = head, p2 = head.next();

        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return true;
            p1 = p1.next();
            p2 = p2.next();
            if (p2 == null)
                break;
            p2 = p2.next();
        }
        return false;
    }

    public Node findLoopEntryNode(Node head) {
        if (head == null)
            return null;
        Node p1 = head, p2 = head;
        while (p2 != null && p2.next() != null) {
            p1 = p1.next();
            p2 = p2.next().next();
            if (p1 == p2)
                break;
        }
        // no loop in the LL
        if (p2 == null || p2.next() == null)
            return null;

        p1 = head;
        while (p1 != p2) {
            p1 = p1.next();
            p2 = p2.next();
        }
        return p1;
    }

    void printLoopedLL(Node head, Node entry) {
        boolean mark = false;
        if (entry == null) return;

        while (head != null) {
            System.out.print(head + "->");
            if (head == entry) {
                if (mark)
                    break;
                else mark = true;
            }
            head = head.next();
        }
    }

    @Test
    public void testFindingEntryPoint() {
        Node head = LinkedListUtil.generateLoopedLLTiny();
        Node entry = findLoopEntryNode(head);
        printLoopedLL(head, entry);
    }

    @Test
    public void testFindEntryPointLongLL() {
        Node head = LinkedListUtil.generateLoopedLL();
        Node entry = findLoopEntryNode(head);
        printLoopedLL(head, entry);
    }


    @Test
    public void testDetermineLoopValidity() {
        org.junit.Assert.assertTrue(determinLoop(LinkedListUtil.generateLoopedLL()));
    }

    @Test
    public void testDetermineLoopNonValidity() {
        org.junit.Assert.assertFalse(determinLoop(LinkedListUtil.generateLinkedList()));
        org.junit.Assert.assertFalse(determinLoop(LinkedListUtil.generateLongUniqueLinkedList()));

    }
}
