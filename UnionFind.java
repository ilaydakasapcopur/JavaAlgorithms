import java.util.Arrays;
import java.util.Scanner;

public class UnionFind {

    private int[] id;
    private int[] size;  
    private int exchangeCounter;  // counter for exchange operations
    private int findCounter;  // counter for find operations


// constructor to initialize the data structures
    public UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i; // each element is initially its own root
            size[i] = 1;
        }
        exchangeCounter = 0;
        findCounter = 0;
    }

    public int getExchangeCounter() {// getter method for exchangeCounter
        return exchangeCounter;
    }

    public int getFindCounter() {// getter method for findCounter
        return findCounter;
    }

    // Find operation to determine the root of a connected component (with path compression)
    public int find(int p) {
        findCounter++;
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    // check if two elements are in the same connected component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

// union operation to connect two elements (with path compression)
public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);

    if (rootP == rootQ) return; // elements are already in the same connected component

    // path compression to attach smaller tree to the root of the larger tree
    if (size[rootP] < size[rootQ]) {
        id[rootP] = rootQ;
        size[rootQ] += size[rootP];
    } else {
        id[rootQ] = rootP;
        size[rootP] += size[rootQ];
    }

    exchangeCounter++;
}


      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        UnionFind quickFind = new UnionFind(n);
        UnionFind quickUnion = new UnionFind(n);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Union");
            System.out.println("2. Find");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("Enter two elements: ");
            int element1 = scanner.nextInt();
            int element2 = scanner.nextInt();

            switch (choice) {
                case 1:
                    quickFind.union(element1, element2);
                    quickUnion.union(element1, element2);
                    break;
                case 2:
                    System.out.println("Quick-Find Result: " + quickFind.connected(element1, element2));
                    System.out.println("Quick-Union Result: " + quickUnion.connected(element1, element2));
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Quick-Find Exchange Operations: " + quickFind.getExchangeCounter());
            System.out.println("Quick-Find Find Operations: " + quickFind.getFindCounter());
            System.out.println("Quick-Find Root Numbers: " + Arrays.toString(quickFind.id));

            System.out.println("Quick-Union Exchange Operations: " + quickUnion.getExchangeCounter());
            System.out.println("Quick-Union Find Operations: " + quickUnion.getFindCounter());
            System.out.println("Quick-Union Root Numbers: " + Arrays.toString(quickUnion.id));
        }

        scanner.close();
    }
}
