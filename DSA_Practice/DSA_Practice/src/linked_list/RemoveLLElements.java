package linked_list;

public class RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode head1 = head;
        dummy.next = head;


        while(temp != null){
            if(temp.val == val ){
                head1 = temp.next;
                if(prev != null){
                    prev.next = temp.next;
                }
                temp.next = null;
                temp = head1;
            }
            else{
                temp = temp.next;
                prev = prev.next;
            }

        }
        return dummy.next;
    }
}
