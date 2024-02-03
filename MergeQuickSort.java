import java.util.Scanner;

public class MergeQuickSort {

     // Method to start the top-down merge sort process for strings
     public void topDownMergeSort(String[] array) {
        if (array.length <= 1) {
            return;
        }
        String[] aux = new String[array.length];
        topDownSplitMerge(array, 0, array.length, aux);
    }

    private void topDownSplitMerge(String[] array, int start, int end, String[] aux) {
        if (end - start <= 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        topDownSplitMerge(array, start, mid, aux);
        topDownSplitMerge(array, mid, end, aux);
        merge(array, start, mid, end, aux);
    }

    private void merge(String[] array, int start, int mid, int end, String[] aux) {
        System.arraycopy(array, start, aux, start, end - start);

        int i = start;
        int j = mid;
        for (int k = start; k < end; k++) {
            if (i < mid && (j >= end || aux[i].compareTo(aux[j]) <= 0)) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    // Method to start the bottom-up merge sort process for strings
    public void bottomUpMergeSort(String[] array) {
        int n = array.length;
        String[] aux = new String[n];
        for (int width = 1; width < n; width = 2 * width) {
            for (int i = 0; i < n; i = i + 2 * width) {
                merge(array, i, Math.min(i + width, n), Math.min(i + 2 * width, n), aux);
            }
        }
    }

    // QuickSort method for strings
    public void quickSort(String[] array) {
        quickSortRecursive(array, 0, array.length - 1);
    }

    private void quickSortRecursive(String[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);

            quickSortRecursive(array, start, partitionIndex - 1);
            quickSortRecursive(array, partitionIndex + 1, end);
        }
    }

    private int partition(String[] array, int start, int end) {
        String pivot = array[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;

                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        String temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Enter the number of elements in the array:");
            int n = scanner.nextInt();
            scanner.nextLine();  // Consume the newline left-over
            String[] array = new String[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLine();
            }

            System.out.println("Choose the sorting algorithm:");
            System.out.println("1. Top-Down MergeSort");
            System.out.println("2. Bottom-Up MergeSort");
            System.out.println("3. QuickSort");
            int choice = scanner.nextInt();

            MergeQuickSort sorter = new MergeQuickSort();

            switch (choice) {
                case 1:
                    sorter.topDownMergeSort(array);
                    break;
                case 2:
                    sorter.bottomUpMergeSort(array);
                    break;
                case 3:
                    sorter.quickSort(array);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            System.out.println("Sorted array:");
            for (String value : array) {
                System.out.print(value + " ");
            }
            System.out.println();

            System.out.println("Do you want to sort another array? (yes/no)");
            scanner.nextLine();  // Consume the newline left-over
            String userResponse = scanner.nextLine();
            continueRunning = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Exiting program.");
        scanner.close();
    }
}
