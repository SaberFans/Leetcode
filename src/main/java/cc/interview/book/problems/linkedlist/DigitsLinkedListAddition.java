package cc.interview.book.problems.linkedlist;

import org.junit.Test;

/**
 * Two number represented by a linked-list, each node contains
 * one digit of the number. The number is stored reversely.
 * Calculate the sum of the two numbers, and save in a new LL.
 */
public class DigitsLinkedListAddition {

    public Node addNumbersAsWhole(Node numberA, Node numberB, int carry){
        if(numberA==null && numberB==null && carry==0)
            return null;
        Node next = new Node(null);
        if(numberA!=null) {
            carry += numberA.getData();
            numberA = numberA.next();
        }
        if(numberB!=null) {
            carry += numberB.getData();
            numberB = numberB.next();
        }

        next.setData(carry%10);
        carry = carry>=10?1:0;

        next.setNext(addNumbersAsWhole(numberA, numberB, carry));

        return next;

    }

    public Node addNumbers(Node number1, Node number2){
        Node result = new Node(null);
        if(number1==null || number2==null)
            return null;
        calculate(number1, number2, result, 0);
        return result;

    }
    void calculate(Node number1, Node number2, Node res, int carry){

        if(number1!=null) {
            carry += number1.getData();
            number1 = number1.next();
        }
        if(number2!=null) {
            carry += number2.getData();
            number2 = number2.next();
        }

        res.setData(carry%10);
        carry = carry>=10?1:0;

        if(number1==null && number2==null  && carry==0)
            return;
        res.setNext(new Node(null));
        calculate(number1, number2, res.next(), carry);

    }
    @Test
    public void test(){
        Node p1 = new Node(null);
        p1.setData(9);

        Node p2 = new Node(null);
        p2.setData(1);

        LinkedListUtil.printLinkedList(addNumbersAsWhole(p1, p2, 0));
    }
    @Test
    public void testDifferentDigitNumber(){
        Node p1 = new Node(null);
        p1.setData(9);
        Node p2 = new Node(p1);
        p2.setData(9);
        Node p3 = new Node(p2);
        p3.setData(9);

        Node q1 = new Node(null);
        q1.setData(1);

        LinkedListUtil.printLinkedList(addNumbersAsWhole(p3, q1, 0));

    }
}
