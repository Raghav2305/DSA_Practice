package linked_list;

public class LL {
    private  int size;
    private   Node head;
    private  Node tail;

    private  class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {

        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int deleteAtIndex(int index){
        if (index == 0){
            return deleteFirst();
        }else if(index == size){
            deleteLast();
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;

        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();

        }

        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int val = tail.value;
        tail = temp;
        temp.next = null;


        size--;
        System.out.println(val);
        return val;

    }

    public int deleteFirst(){
        int num = head.value;
        head = head.next;

        size--;
        System.out.println(num);
        return num;
    }

    public void insertAtIndex(int val, int index){
        Node temp = head;
        for (int i = 1; i <= index - 1 ; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size+=1;
    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);

    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, --index, node.next);
        return node;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public  void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public static LL MergeTwoLinkedList(LL list1, LL list2){
        Node first = list1.head;
        Node second = list2.head;
        LL ans = new LL();

        while(first != null && second != null){
            if(first.value < second.value){
                ans.insertLast(first.value);
                first = first.next;
            }
            else{
                ans.insertLast(second.value);
                second = second.next;
            }
        }

        while (first!= null){
            ans.insertLast(first.value);
            first = first.next;
        }
        while(second!=null){
            ans.insertLast(second.value);
            second = second.next;
        }
        return ans;
    }

    public boolean DetectCycle(Node head){
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }public int CycleLength(Node head){
        int count = 0;
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                Node temp = slow;
                do{
                    temp = temp.next;
                    count++;
                }while(temp != slow);
                return count;
            }
        }
        return 0;
    }

    public Node Cycle2FindStart(Node head){
        if(!DetectCycle(head)){
            return null;
        }

        int length = CycleLength(head);
        if(length == 0) return null;

        Node first = head;
        Node second = head;

        while(length > 0){
            second = second.next;
            length --;
        }

        while (first != second){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public boolean IsHappy(int num){
        int slow = num;
        int fast = num;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }
    private int findSquare(int num){
        int ans = 0;
        while(num > 0){
            int modulo = num % 10;
            ans += modulo * modulo;
            num /= 10;
        }
        return ans;
    }

    public Node MiddleOfLL(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public  Node MergeTwo_LinkedList_FromHead(Node first, Node second){
        Node dummy = new Node();
        Node tail = dummy;
        while(first != null && second != null){
            if(first.value < second.value){
                tail.next = first;
                first = first.next;
                tail = tail.next;
            }
            else{
                tail.next = second;
                second = second.next;
                tail = tail.next;
            }
        }

        tail.next = (first != null) ? first : second;
        return  dummy.next;
    }

    public Node Sort_Using_MergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = MiddleOfLL(head);
        Node left = Sort_Using_MergeSort(head);
        Node right = Sort_Using_MergeSort(mid);
        return MergeTwo_LinkedList_FromHead(left, right);
    }

    public Node Reverse(Node node){
        if (node == null || node.next == null) {
            return node;
        }

        Node rest = Reverse(node.next);

        node.next.next = node;
        node.next = null;

        return rest;
    }

    public Node LL_Inplace_Reversal(Node head){
        if(head == null){
            return head;
        }
        Node prev = null;
        Node pres = head;
        Node next = pres.next;
        
        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next!=null){
                next = next.next;
            }

        }

        head = prev;
        return head;
    }

    public Node Reverse_Sub_LinkedList(Node head, int left, int right){
        Node dummy = new Node(0, head);

        Node Left_previous = dummy;
        Node current = head;
        Node previous = null;

        for (int i = left; current!=null && i >= left-1; i--) {
            Left_previous = current;
            current = current.next;
        }

        if(current != null){
            for (int i = 0; i < right - left + 1 ; i++) {
                Node temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }
        }
        Left_previous.next.next = current;
        Left_previous.next = previous;
        return dummy.next;
    }

    public boolean Palindrome_LinkedList(Node head){
        if(head == null){
            return false;
        }

        Node tail = null;
        Node temp = head;

        Node mid = MiddleOfLL(temp);
        Node reversed_head =  Reverse(mid);

        Node first_LL_head = temp;
        Node second_LL_head = reversed_head;

        while(first_LL_head != null && reversed_head != null){
            if(first_LL_head.value != reversed_head.value){
                break;
            }
            first_LL_head = first_LL_head.next;
            reversed_head = reversed_head.next;
        }
        Reverse(second_LL_head);
        return first_LL_head == null || reversed_head == null;
    }

    public Node Reorder_LinkedList(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node mid = MiddleOfLL(head);
        Node first_head = head;
        Node second_head = Reverse(mid);
//        Node temp_second_head = second_head;

        while(first_head != null && second_head != null){
            Node temp = first_head.next;
            first_head.next = second_head;
            first_head = temp;

            temp = second_head.next;
            second_head.next = first_head;
            second_head = temp;

            if(first_head != null){
                first_head.next = null;
            }

        }
        return head;
    }

    // *** Revise this again ****
    public Node Reverse_every_K_Group(Node head, int k){
        if(head == null){
            return null;
        }

        Node dummy = new Node(0, head);
        Node Group_Previous = dummy;

        while(true){
            Node kth = get_every_k_node(Group_Previous, k);
            if(kth == null){
                break;
            }
            Node group_next = kth.next;

            // Reversing logic starts here.....

            Node prev = group_next;
            Node curr = Group_Previous.next;

            while(curr != group_next){
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            Node tmp = Group_Previous.next;
            Group_Previous.next  = kth;
            Group_Previous = tmp;
        }
        return  dummy.next;
    }
    private Node get_every_k_node(Node curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k-=1;
        }
        return curr;
    }

    public Node Rotate_Linked_List(Node head, int k){
        if(k <=0 || head == null || head.next == null){
            return head;
        }

        Node last = head;
        int  length = 1;
        while(last.next!=null){
            last = last.next;
            length ++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;

        Node newLast = head;
        for (int i = 0; i < skip -1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public int pairSum(Node head) {

            Node temp = head;
            if(head == null){
                return -1;
            }

            Node start = head;
            int maxSum = 0;
            Node mid = MiddleOfLL(start);
            Node secondhead = Reverse(mid);


            while(secondhead != null){
                maxSum = Math.max(maxSum, temp.value + secondhead.value);
                temp = temp.next;
                secondhead = secondhead.next;
            }
            return maxSum;

    }


    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertLast(3);
        list.insertLast(4);
//        list.insertAtIndex(10, 2);
//        list.insertAtIndex(10, 3);
//        list.insertRec(5, 2);
        list.display();
//        list.duplicates();
        list.head = list.Reverse(list.head);
        list.display();
//        list.display();
//        Node ans = list.MiddleOfLL(list.head);
//        System.out.println(ans.value);
//        LL first = new LL();
//        LL second = new LL();
//
//        first.insertLast(1);
//        first.insertLast(2);
//        first.insertLast(5);
//
//        second.insertLast(1);
//        second.insertLast(2);
//        second.insertLast(9);
//        second.insertLast(14);
//
//        LL ans = LL.MergeTwoLinkedList(first, second);
//        ans.display();

    }
}
