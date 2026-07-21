class MyCircularQueue {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = null;
        this.tail = head;
    }

    // add to the tail, remove from the head

    public boolean enQueue(int value) {
        if (size == capacity)
            return false;
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;

        return true;
    }

    public boolean deQueue() {
        if (head == null) return false;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) return -1;

        return head.val;
    }

    public int Rear() {
        if (size == 0) return -1;

        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */