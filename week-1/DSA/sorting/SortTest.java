package DSA.sorting;

public class SortTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Alice", 2500.0),
            new Order("O102", "Bob", 1200.0),
            new Order("O103", "Charlie", 5000.0),
            new Order("O104", "Diana", 3000.0)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        SortAlgorithms.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reset array for Quick Sort
        orders = new Order[] {
            new Order("O101", "Alice", 2500.0),
            new Order("O102", "Bob", 1200.0),
            new Order("O103", "Charlie", 5000.0),
            new Order("O104", "Diana", 3000.0)
        };

        // Quick Sort
        System.out.println("\nQuick Sort:");
        SortAlgorithms.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

