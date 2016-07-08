package cc.interview.book.problems.linkedlist;

import org.junit.Test;

/**
 * Created by epttwxz on 07/07/2016.
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
    void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.getData() + "->");
            head= head.next();
        }
        System.out.println("null");
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
