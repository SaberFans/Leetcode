package cc.interview.book.problems.linkedlist;

/**
 * Node class used in LinkedList data structure.
 */
public class Node {
    private Node next= null;
    private int data;

    public Node(Node next) {
        this.next = next;
    }
    public Node next() {
        return this.next;
    }
    public void setNext(Node node){
         this.next = node;
    }
    public int getData(){
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj ==null)
            return false;
        if(obj == this)
            return true;

        if(obj instanceof Node){
            if(((Node) obj).getData()==((Node) obj).getData()){
                if(this.next()==((Node) obj).next()){
                    return true;
                }
                else if(next()!=null){  // compare next node.
                    return this.next().equals(((Node) obj).next);
                }
                else{                  // obj next node needs to be null as well.
                    return ((Node) obj).next()==null;
                }
            }
            else
                return false;
        }
        else{
            return false;
        }


    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
