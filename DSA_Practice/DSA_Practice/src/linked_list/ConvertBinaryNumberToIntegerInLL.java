package linked_list;

public class ConvertBinaryNumberToIntegerInLL {
    public int getDecimalValue(ListNode head) {
        int power = 0;
        ListNode temp = head;
        int num = 0;

        while(temp != null){
            int len = getLength(temp);
            int curr_power = len - 1;

            num += temp.val * (Math.pow(2, curr_power));
            temp = temp.next;

        }
        return num;

    }

    public int getLength(ListNode head){
        int count = 0;
        while(head != null){
            count+= 1;
            head = head.next;
        }
        return count;
    }
}
