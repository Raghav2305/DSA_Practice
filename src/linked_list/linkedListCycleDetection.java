package linked_list;

public class linkedListCycleDetection {
    int val;
    linkedListCycleDetection next;

    public linkedListCycleDetection(int val, linkedListCycleDetection next) {
        this.val = val;
        this.next = next;
    }

    public  boolean detect(linkedListCycleDetection head){
        linkedListCycleDetection fast = head;
        linkedListCycleDetection slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
