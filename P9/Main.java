
class MyLinkedList<T> {

    // Node class
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int count;

    // Insert element at the end
    public void insert(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        count++;
        System.out.println(data + " inserted.");
    }

    // Delete first occurrence of an element
    public void delete(T data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (java.util.Objects.equals(head.data, data)) {
            head = head.next;
            count--;
            System.out.println(data + " deleted.");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               !java.util.Objects.equals(temp.next.data, data)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(data + " not found.");
        } else {
            temp.next = temp.next.next;
            count--;
            System.out.println(data + " deleted.");
        }
    }

    // Search for an element
    public boolean search(T data) {
        Node temp = head;

        while (temp != null) {
            if (java.util.Objects.equals(temp.data, data)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // Display all elements
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.print("List: ");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Return size
    public int size() {
        return count;
    }

    // Check whether list is empty
    public boolean isEmpty() {
        return head == null;
    }
}

public class Main {
    public static void main(String[] args) {

        // Integer linked list
        System.out.println("=== Integer Linked List ===");

        MyLinkedList<Integer> numbers = new MyLinkedList<>();

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);

        numbers.traverse();

        System.out.println("Search 20: " + numbers.search(20));
        System.out.println("Size: " + numbers.size());
        System.out.println("Is empty: " + numbers.isEmpty());

        numbers.delete(20);
        numbers.traverse();

        System.out.println("\n=== String Linked List ===");

        MyLinkedList<String> names = new MyLinkedList<>();

        names.insert("Aditya");
        names.insert("Harsh");
        names.insert("Riya");

        names.traverse();

        System.out.println("Search Harsh: " + names.search("Harsh"));
        System.out.println("Size: " + names.size());

        names.delete("Aditya");
        names.traverse();

        names.delete("Unknown");

        System.out.println("Is empty: " + names.isEmpty());
    }
}
