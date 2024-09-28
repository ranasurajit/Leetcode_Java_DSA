/**
 * TC: O(1)
 * SC: O(k) ~ O(1) as deque is itself the output
 */
class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int count;
    private int size;

    public MyCircularDeque(int k) {
        size = k;
        deque = new int[size];
        front = 0;
        rear = size - 1;
        count = 0;
    }
    
    /**
     * TC: O(1)
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + size) % size;
        deque[front] = value;
        count++;
        return true;
    }
    
    /**
     * TC: O(1)
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % size;
        deque[rear] = value;
        count++;
        return true;
    }
    
    /**
     * TC: O(1)
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        deque[front] = -1;
        front = (front + 1) % size;
        count--;
        return true;
    }
    
    /**
     * TC: O(1)
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        deque[rear] = -1;
        rear = (rear - 1 + size) % size;
        count--;
        return true;
    }
    
    /**
     * TC: O(1)
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }
    
    /**
     * TC: O(1)
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }
    
    /**
     * TC: O(1)
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * TC: O(1)
     */
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
