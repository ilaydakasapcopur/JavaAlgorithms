import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainSort {

//HOMEWORK1

    // Method to sort the array in ascending order
    public static void sortAscending(int[] arr) {
        int temp = 0; // create to use it in sorting methods as a temprorary value
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Method to sort the array in descending order
    public static void sortDescending(int[] arr) {
        int temp = 0; // create to use it in sorting methods as a temprorary value
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
//HOMEWORK1 
//HOMEWORK2

    //finalizing the values to the strings
    private static final Map<String, Integer> cardValues = new HashMap<>();

    static {
        cardValues.put("A", 14);
        cardValues.put("K", 13);
        cardValues.put("Q", 12);
        cardValues.put("J", 11);
    }

    //getting string card values and turning them into integers
    private static int[] convertToNumericValues(String[] cards) {
        int[] numericValues = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (cardValues.containsKey(cards[i])) {
                numericValues[i] = cardValues.get(cards[i]);
            } else {
                numericValues[i] = Integer.parseInt(cards[i]);
            }
        }
        return numericValues;
    }

    // convert sorted numeric values back to card strings for display
    private static String[] convertToCardStrings(int[] numericValues) {
        String[] cardStrings = new String[numericValues.length];
        for (int i = 0; i < numericValues.length; i++) {
            for (Map.Entry<String, Integer> entry : cardValues.entrySet()) {
                if (entry.getValue() == numericValues[i]) {
                    cardStrings[i] = entry.getKey();
                    break;
                }
            }
            // if the numeric value is not found in the map, assume it's a numeric card
            if (cardStrings[i] == null) {
                cardStrings[i] = String.valueOf(numericValues[i]);
            }
        }
        return cardStrings;
    }

    // selection sort implementation
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // print card method to print the deck of cards
    public static void printCards(String[] cards) {
        for (String card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

//HOMEWORK2
//HOMEWORK3

//creating an inner class for this homework
   public static class ResizingArrayQueueAndStackOfStrings{
    private String[] array;
    private int size; // number of elements in the array
    private int front; //value of the first element
    private int capacity; //maximum capacity

    //constructor initialization
    public ResizingArrayQueueAndStackOfStrings() {
        array = new String[1];
        size = 0;
        front = 0;
        capacity = 1;
    }

    private void resize(int newCapacity) { //resizing method 
        String[] newArray = new String[newCapacity]; //creating temporary array
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        capacity = newCapacity;
    }

    public void push(String item) { //add item to top of stack
        if (size == capacity) {
            resize(2 * capacity); // resize the array if its full
}
        array[size++] = item;
    }

    public String pop() { //remove item from top of stack
        if (isEmpty()) {
            throw new IllegalStateException("pop from an empty stack");
        }
        String item = array[--size];
        if (size > 0 && size == capacity / 4) {// resize the array if it becomes too small
            resize(capacity / 2);
        }
        return item;
    }

    public void enqueue(String item) { // enqueue is the same as push method
        push(item);  
    }

    public String dequeue() { //remove item from the beginning of the list
        if (isEmpty()) {
            throw new IllegalStateException("dequeue from an empty queue");
        }
        String item = array[front];
        front = (front + 1) % array.length;
        size--;
        if (size > 0 && size == capacity / 4) {// resize the array if it becomes too small
            resize(capacity / 2);
        }
        return item;
    }

    //checking if the array is empty in that current time
    public boolean isEmpty() {
        return size == 0;
    }

    //print content methods for the display
    public void printContents() {
        System.out.print("Contents: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[(front + i) % array.length] + " ");
        }
        System.out.println();
    }
   }
 

//HOMEWORK3
             


//MAIN METHOD
public static void main(String[] args) {


 //HOMEWORK1

        Scanner scanner3 = new Scanner(System.in); //use scanner to take the input
        int length = 0; //create to define the array length

        System.out.println("Enter the size of the array:");
        if (scanner3.hasNextInt()) {
            length = scanner3.nextInt(); //take the input
        }
        int[] arr = new int[length]; //create an array with given length

        //take the input for the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            if (scanner3.hasNextInt()) {
                arr[i] = scanner3.nextInt();
            }
        }

        //print the elements of the array in given order first
        System.out.println("The elements of the array are:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // call the method sortAscending to sort the elements in ascending order
        sortAscending(arr);

        System.out.println("Elements of the array sorted in ascending order:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        //call the method sortDescending to sort the elements in descending order
        sortDescending(arr);

        System.out.println("Elements of the array sorted in descending order:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
        System.out.println();

//HOMEWORK1
//HOMEWORK2

        // get user input for the size of the array
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner2.nextInt();

        // get user input for the cards
        String[] cards = new String[size];
        System.out.println("Enter the cards in the array (A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1):");
        for (int i = 0; i < size; i++) {
            System.out.print("Card " + (i + 1) + ": ");
            cards[i] = scanner2.next().toUpperCase(); // convert to uppercase for case-insensitivity
        }

        // convert card strings to numeric values for sorting
        int[] numericCards = convertToNumericValues(cards);

        System.out.println();

        // display the unsorted deck
        System.out.println("Unsorted deck:");
        printCards(cards);
        System.out.println();

        // perform selection sort
        selectionSort(numericCards);

        // convert sorted numeric values back to card strings for display
        String[] sortedCards = convertToCardStrings(numericCards);

        // display the sorted deck
        System.out.println("Sorted deck:");
        printCards(sortedCards);
        System.out.println();
        System.out.println();

 //HOMEWORK2
 //HOMEWORK3  

        //to call the methods in the inner class 
        Scanner scanner1 = new Scanner(System.in);
        ResizingArrayQueueAndStackOfStrings stack = new ResizingArrayQueueAndStackOfStrings();
        ResizingArrayQueueAndStackOfStrings queue = new ResizingArrayQueueAndStackOfStrings();

        //create the choices for the user in terminal
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Push ");
            System.out.println("2. Pop ");
            System.out.println("3. Enqueue ");
            System.out.println("4. Dequeue ");
            System.out.println("5. Print stack or queue");
            System.out.println("6. Exit");

            int choice = scanner1.nextInt();
            scanner1.nextLine();  // get the input

            //for each choice use switch-case 
            switch (choice) {
                case 1:
                    System.out.println("Enter a string to push : ");
                    String pushString = scanner1.nextLine();
                    stack.push(pushString);
                    break;
                case 2:
                    try {
                        String poppedString = stack.pop();
                        System.out.println("Popped string: " + poppedString);
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter a string to enqueue : ");
                    String enqueueString = scanner1.nextLine();
                    queue.enqueue(enqueueString);
                    break;
                case 4:
                    try {
                        String dequeuedString = queue.dequeue();
                        System.out.println("Dequeued string: " + dequeuedString);
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                System.out.print("Stack ");
                stack.printContents();
                System.out.print("Queue ");
                queue.printContents();
                System.out.println();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
        }
    




    

    
    
}}}
