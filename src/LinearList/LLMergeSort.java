package LinearList;

/**
 * Created by yang on 16/03/2017.
 */
public class LLMergeSort {

    static public LLNode mergesort(LLNode head){
        if(head!=null && head.next!=null){
            LLNode mid = getMidNode(head);
            LLNode second = mid.next;
            mid.next = null;
            return merge(mergesort(head), mergesort(second));
        }
        return head;
    }
    static private LLNode merge(LLNode first, LLNode second){
        LLNode it = new LLNode();
        LLNode ffirst = it;
        while(first!=null&&second!=null){
            if(first.compareTo(second)<0) {
                it.next = first;
                first = first.next;
            }
            else{
                it.next = second;
                second = second.next;
            }
            it = it.next;
        }
        it.next = first==null?second:first;

        return ffirst.next;
    }
    static private LLNode getMidNode(LLNode curNode){
        LLNode slow = curNode, quick = curNode.next.next;
        while(quick!=null&&quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LLNode head = LLNode.convertArrayToLL(new int[]{12,11,10,9,8,7,6,5,4,3,2,1});
        LLNode newHead = LLMergeSort.mergesort(head);
        System.out.println(newHead);

    }
}
