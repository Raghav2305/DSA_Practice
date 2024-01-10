package linked_list;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}

public class Remove_Nth_Node_from_End {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode temp  = head;
        ListNode calc  = head;


        int length_of_list = calculateLength(calc);

        while(temp != null){
            if(length_of_list == n){
                ListNode curr = temp.next;
                temp.next = null;
                prev.next = curr;
            }

            temp = temp.next;
            prev = prev.next;
            length_of_list --;

        }
        return dummy.next;
    }

    public int calculateLength(ListNode calc){
        int len = 0;

        while(calc != null){
            len += 1;
            calc = calc.next;
        }
        return len;
    }
}
