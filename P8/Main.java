
import java.util.Scanner;

// Stack ADT using an array
class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }

        arr[++top] = value;
        System.out.println(value + " pushed into Stack.");
    }

    // Pop operation
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }

        System.out.println("Popped: " + arr[top--]);
    }

    // Peek operation
    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top element: " + arr[top]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Queue ADT using a circular array
class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow! Queue is full.");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;

        System.out.println(value + " inserted into Queue.");
    }

    // Dequeue operation
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow! Queue is empty.");
            return;
        }

        System.out.println("Dequeued: " + arr[front]);
        front = (front + 1) % capacity;
        size--;
    }

    // Front operation
    public void showFront() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Front element: " + arr[front]);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack stack = new Stack(5);
        Queue queue = new Queue(5);

        int choice, value;

        do {
            System.out.println("\n===== ADT MENU =====");
            System.out.println("1. Push into Stack");
            System.out.println("2. Pop from Stack");
            System.out.println("3. Peek Stack");
            System.out.println("4. Display Stack");
            System.out.println("5. Enqueue into Queue");
            System.out.println("6. Dequeue from Queue");
            System.out.println("7. Show Queue Front");
            System.out.println("8. Display Queue");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter an integer.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    if (sc.hasNextInt()) {
                        value = sc.nextInt();
                        stack.push(value);
                    } else {
                        System.out.println("Invalid value!");
                        sc.next();
                    }
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.print("Enter value: ");
                    if (sc.hasNextInt()) {
                        value = sc.nextInt();
                        queue.enqueue(value);
                    } else {
                        System.out.println("Invalid value!");
                        sc.next();
                    }
                    break;

                case 6:
                    queue.dequeue();
                    break;

                case 7:
                    queue.showFront();
                    break;

                case 8:
                    queue.display();
                    break;

                case 9:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);

        sc.close();
    }
}
