/**
 * 6_Solution
 */
public class Solution_6 {
    public static void main(String[] args) {
        
        Solution_6 s = new Solution_6();

        int[] test = {1};
        
        LList l = new LList(test);

        ListNode ans = s.oddEvenList(l.getHead());
        System.out.println(s.printans(ans)); 

    }

    ListNode oddEvenList(ListNode head) {

        if (head==null) {
            return head;
        }

        int i = 1;

        ListNode odd = head;
        ListNode oddHead = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        ListNode iter = head;

        while (iter!=null) {

            if (i%2==0 && i>=3) {
                even.next = iter;
                even = iter;
            }else if (i%2 != 0 && i>=3){
                odd.next = iter;
                odd = iter;
            }

            i+=1;
            iter = iter.next;
        }
        
        
        head = oddHead;
        odd.next = evenHead;
        if (even!=null) {
            even.next = null;
        }
        return head;
    }

    String printans(ListNode head){
        String list = "";

        ListNode nxt = head;
        
        while (nxt!=null) {
            list += Integer.toString(nxt.val) + " ";
            nxt = nxt.next;
        }

        return list;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString(){
        return Integer.toString(this.val);
    }
  }

class LList{
        
    public ListNode head;

    LList(int[] Head){
        this.head = new ListNode(Head[0]);
        ListNode prev = this.head;

        for (int i = 1; i < Head.length; i++) {

            prev.next = new ListNode(Head[i]);
            prev = prev.next;
        }

    }

    ListNode getHead(){
        return this.head;
    }
    
    @Override
    public String toString() {
        String list = "";

        ListNode nxt = this.head;
        
        while (nxt!=null) {
            list += Integer.toString(nxt.val) + " ";
            nxt = nxt.next;
        }

        return list;
    }
}