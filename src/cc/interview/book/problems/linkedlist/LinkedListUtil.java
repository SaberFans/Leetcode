package cc.interview.book.problems.linkedlist;

import org.junit.Test;

/**
 * LinkedList Util class for handling Linked List operation,
 * like dealing with nodes' operation.
 */
public class LinkedListUtil {

    public static Node delete(Node head, int data){
        Node last = null;  // keep track of last non-data node.
        Node cur = head;
        while(cur!=null){
            if(cur.getData()==data){
                cur = cur.next();
                if(last==null){
                    head = cur;
                }
                else {
                    last.setNext(cur);
                }
            }
            else{
                last = cur;
                cur = cur.next();
            }
        }
        return head;
    }

    public static Node findNthFromLast(Node head, int pos) {
        if (head == null || pos < 1)
            return null;
        Node p1 = head, p2 = head;
        for (int i = 0; i < pos - 1; i++) {
            p1 = p1.next();
            if (p1 == null)    // return null, if size < pos
                return null;
        }
        while (p1.next() != null) {
            p1 = p1.next();
            p2 = p2.next();
        }

        return p2;

    }

    @Test
    public void testFindNthFromLast() {
        Node head = generateLongUniqueLinkedList();
        for (int i = 1; i <= 6; i++)
            org.junit.Assert.assertEquals(findNthFromLast(head, i).toString(), String.valueOf(i - 1));
        for (int i = 7; i <= 10; i++)
            org.junit.Assert.assertEquals(findNthFromLast(head, i), null);
    }
    static public void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.getData() + "->");
            head= head.next();
        }
        System.out.println("null");
    }

    Node generateLongUniqueLinkedList() {
        Node p0 = new Node(null);
        p0.setData(0);
        Node p1 = new Node(p0);
        p1.setData(1);
        Node p2 = new Node(p1);
        p2.setData(2);
        Node p3 = new Node(p2);
        p3.setData(3);
        Node p4 = new Node(p3);
        p4.setData(4);
        Node p5 = new Node(p4);
        p5.setData(5);

        return p5;
    }
    Node generateLinkedList(){
        Node end = new Node(null);
        end.setData(1);
        Node p3 = new Node(end);
        p3.setData(0);
        Node p2 = new Node(p3);
        p2.setData(1);
        Node p1 = new Node(p2);
        p1.setData(1);

        return p1;
    }

    @Test
    public void test(){
        Node headNode1 = generateLinkedList();
        headNode1 = delete(headNode1, 1);
        printLinkedList(headNode1);

        Node headNode2 = generateLinkedList();
        headNode2 = delete(headNode2, 1 );
        printLinkedList(headNode2);

        org.junit.Assert.assertEquals(headNode1, headNode2);


    }
}
