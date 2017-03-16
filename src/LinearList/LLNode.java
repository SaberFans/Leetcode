package LinearList;

/**
 * Created by yang on 15/03/2017.
 */
public class LLNode implements Comparable<LLNode>{
    LLNode next;
    int val;
    LLNode(){}
    LLNode(int val){
        this.val = val;
    }
    public static LLNode convertArrayToLL(int[]array){
        if(array!=null&&array.length>0){
            LLNode head = new LLNode(array[0]);
            LLNode cur = head;
            for(int i=1;i<array.length;i++){
                cur.next = new LLNode(array[i]);
                cur = cur.next;
            }
            return head;
        }
        return null;
    }

    @Override
    public String toString() {
        LLNode cur = this;
        StringBuilder llpout = new StringBuilder();
        while(cur!=null){
            llpout.append(cur.val + "->");
            cur = cur.next;
        }
        llpout.append("null");
        return llpout.toString();
    }


    public static void main(String[] args) {
        System.out.println(LLNode.convertArrayToLL(new int[]{1,2,5}));

    }

    @Override
    public int compareTo(LLNode o) {
        if(this.equals(o))  return 0;
        return o.val>this.val?-1:1;
    }
}
