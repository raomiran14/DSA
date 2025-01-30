import java.util.Scanner;
    public class BinarySearchSimple {
        public static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == target) {
                    return mid; // Target found
                } else if (arr[mid] < target) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
            return -1; // Target not found
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input sorted array
            System.out.println("Enter the number of elements:");
            int n = scanner.nextInt();
            int[] array = new int[n];
            System.out.println("Enter the sorted elements:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            // Input target value
            System.out.println("Enter the target value:");
            int target = scanner.nextInt();

            // Perform binary search
            int result = binarySearch(array, target);

            // Output result
            if (result != -1) {
                System.out.println("Target found at index: " + result);
            } else {
                System.out.println("Target not found.");
            }

            scanner.close();
        }
    }


