class MinStack {
    Stack<Integer> main;
    Stack<Integer> extra;

    public MinStack() {
        main = new Stack();
        extra = new Stack();
    }

    public void push(int val) {
        main.push(val);
        if (extra.isEmpty()) {
            extra.push(val);
        } else {
            extra.push(Math.min(extra.peek(), val));
        }
    }

    public void pop() {
        main.pop();
        extra.pop();
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return extra.peek();
    }
}
