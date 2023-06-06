public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        if (top != null) {
            top.prev = newNode;
        }
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = top.element;
        top = top.next;
        if (top != null) {
            top.prev = null;
        }
        size--;
        return element;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
