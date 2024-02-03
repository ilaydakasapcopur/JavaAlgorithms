import java.util.Scanner;

public class SortingAlgorithms {
    private static int[] array;  // declare the array outside the switch statement

    // insertion Sort algorithm
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // move elements of array[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // selection Sort algorithm
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the found minimum element with the first element in the unsorted part
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // print the elements of an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Enter a new array");
            System.out.println("2. Perform Insertion Sort");
            System.out.println("3. Perform Selection Sort");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();

                    array = new int[size];  // initialize the array here

                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size; i++) {
                        array[i] = scanner.nextInt();
                    }
                    printArray(array);
                    break;

                case 2:
                    if (array == null) {
                        System.out.println("Please enter an array first.");
                        break;
                    }
                    System.out.println();

                    System.out.println("Original array for Insertion Sort:");
                    printArray(array);

                    insertionSort(array);
                    System.out.println();

                    System.out.println("Sorted array using Insertion Sort:");
                    printArray(array);
                    break;

                case 3:
                    if (array == null) {
                        System.out.println("Please enter an array first.");
                        break;
                    }
                    System.out.println();

                    System.out.println("Original array for Selection Sort:");
                    printArray(array);

                    selectionSort(array);
                    System.out.println();

                    System.out.println("Sorted array using Selection Sort:");
                    printArray(array);
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

