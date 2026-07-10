package DSA.library;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B101", "Java Programming", "James Gosling"),
            new Book("B102", "Data Structures", "Robert Lafore"),
            new Book("B103", "Algorithms", "Thomas Cormen"),
            new Book("B104", "Operating Systems", "Silberschatz")
        };

        // Linear Search
        int indexLinear = SearchAlgorithms.linearSearch(books, "Algorithms");
        System.out.println("Linear Search result: " + (indexLinear != -1 ? books[indexLinear] : "Not Found"));

        // Sort array for Binary Search
        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        // Binary Search
        int indexBinary = SearchAlgorithms.binarySearch(books, "Algorithms");
        System.out.println("Binary Search result: " + (indexBinary != -1 ? books[indexBinary] : "Not Found"));
    }
}
