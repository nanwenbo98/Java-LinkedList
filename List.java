/**
 * Int type singly linkedlist class
 *
 * @author Wenbo Nan
 *
 */
public class List {

    private final class Node {

        /**
         * Data in node.
         */
        private int data;

        /**
         * Next node in linked list, or null.
         */
        private Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    private Node top;

    private int length;

    public List() {
        this.length = 0;
    }

    /**
     * Append an element into the linkedlist
     *
     * @param x
     *            value of element to be appended
     */
    public void append(int x) {
        Node newNode = new Node(x);
        Node current = this.top;
        if (current != null) {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        } else {
            this.top = newNode;
        }
        this.length++;
    }

    /**
     * Remove the tail element from a linkedlist
     *
     * @return value of the tail element of the linkedlist
     */
    public int removeTail() {
        assert this.length > 0 : "Violcation of: list is not empty";
        int tail;
        if (this.length == 1) {
            tail = this.top.data;
            this.top = null;
        } else {
            Node current = this.top;
            while (current.next.next != null) {
                current = current.next;
            }
            tail = current.next.data;
            current.next = null;
        }
        this.length--;
        return tail;
    }

    /**
     * Remove all element in the linkedlist that is greater than a target value
     *
     * @param x
     *            target value of which elements with greater value are to be
     *            removed
     */
    public void removeAbove(int x) {
        if (this.length > 0) {
            while (this.top.data > x && this.top.next != null) {
                Node temp_node = this.top.next;
                this.top.next = temp_node.next;
                this.top = temp_node;
                this.length--;
            }
            if (this.top.next == null) {
                if (this.top.data > x) {
                    this.top = null;
                    this.length--;
                }
            } else {
                Node current = this.top.next;
                Node previous = this.top;
                while (current != null) {
                    if (current.data > x) {
                        Node temp_node = current.next;
                        if (temp_node == null) {
                            current.next = null;
                        } else {
                            current.next = temp_node.next;
                        }
                        current = current.next;
                        previous.next = current;
                        this.length--;
                    } else {
                        current = current.next;
                        previous = previous.next;
                    }
                }
            }
        }
    }

    /**
     * Gets the size of the linkedlist
     *
     * @return size of the linkedlist
     */
    public int size() {
        return this.length;
    }

    /**
     * Finds if value x is in the linkedlist
     *
     * @param x
     *            the value to be found in the linkedlist
     * @return whether the value of x is in the linkedlist or not
     */
    public boolean contains(int x) {
        Node current = this.top;
        while (current != null) {
            if (current.data == x) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }
}
