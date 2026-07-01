package DSA.library;

public class SearchAlgorithms {

    // Linear Search by title
    public static int linearSearch(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return i; // found
            }
        }
        return -1;
    }

    // Binary Search by title (array must be sorted by title)
    public static int binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (cmp == 0) {
                return mid; // found
            } else if (cmp < 0) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1;
    }
}
