class MyLinkedList {

    ListNode head = null;

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        if (index < 0 || head == null) {
            return -1;
        }
        if (index == 0) {
            return head.val;
        }
        ListNode current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
            if (count == index && current != null) {
                return current.val;
            }
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode next = head;
            head = new ListNode(val);
            head.next = next;
        }
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
            return; 
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            prev = current;
            current = current.next;
        }
        prev.next = new ListNode(val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            prev = current;
            current = current.next;
            count++;
            if (count == index) {
                break;
            }
        }
        if (prev != null) {
            prev.next = new ListNode(val);
            prev.next.next = prev.next != null ? current : null;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            prev = current;
            current = current.next;
            count++;
            if (count == index) {
                break;
            }
        }
        prev.next = current != null ? current.next : null;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
