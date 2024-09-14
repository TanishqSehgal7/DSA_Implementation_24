package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class BeautifulTriplets {

    // Function to find a number using binary search
    public static boolean binarySearch(int[] arr, int start, int end, int value) {
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == value) {
                return true;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Function to count beautiful triplets using binary search
    public static int countBeautifulTriplets(int[] arr, int d) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int secondValue = arr[i] + d;
            int thirdValue = arr[i] + 2 * d;

            // Search for second and third values using binary search
            if (binarySearch(arr, i + 1, arr.length - 1, secondValue) &&
                binarySearch(arr, i + 1, arr.length - 1, thirdValue)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the array size and the difference d
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        System.out.print("Enter the value of d: ");
        int d = scanner.nextInt();
        
        // Read the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort the array to apply binary search
        Arrays.sort(arr);

        // Get the count of beautiful triplets
        int result = countBeautifulTriplets(arr, d);
        
        System.out.println("Number of beautiful triplets: " + result);
    }
}
