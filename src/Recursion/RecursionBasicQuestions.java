package Recursion;

import java.util.HashMap;
import java.util.Scanner;

public class RecursionBasicQuestions {
	
	static Scanner scn = new Scanner(System.in);
	
	public static int findPower(int x, int n) {
		
		if(n == 0) {
			return 1;
		}
		
		if(n == 1) {
			return x;
		}
		
		int ans = findPower(x, n/2);
		
		if(n%2 == 0) // x^(n/2) * x^(n/2)
			return ans * ans;
		else // x * x^(n/2) * x^(n/2)
			return x * ans * ans;	
	}
	
	
	public static int findFactorial(int x) {
		
		
		if(x == 0 || x == 1) {
			return x;
		}
		
		return x * findFactorial(x-1);
		
	}
	
	
	public static void printCountingUptoN(int n) {
		
		if(n == 0)
			return;
		
		printCountingUptoN(n-1);
		
		System.out.print(n + " ");
	}
	
	
	public static int fibonacciSeries(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fibonacciSeries(n-1) + fibonacciSeries(n-2);
		
	}
	
	public static int distinctWaysOfClimbingStairs(int n) {
		
		if(n < 0)
			return 0;
		
		if(n == 0)
			return 1;
		
		return distinctWaysOfClimbingStairs(n-1) + distinctWaysOfClimbingStairs(n-2);
		
	}
	
	public static void sayDigit(int n, HashMap<Integer,String> map) {
		
		if(n == 0)
			return;
		
		int digit = n%10;
		
		sayDigit(n/10, map);
		System.out.print(map.get(digit) + " ");
	}
	
	
	public static int binarySearchUsingRecursion(int arr[], int x, int s, int e) {
		
		int mid = s + (e-s)/2;
		
		if(s > e)
			return -1;
		
		if(x == arr[mid])
			return mid;
		
		
		if(x > arr[mid]) {
			return binarySearchUsingRecursion(arr, x, mid+1, e);
		} else {
			return binarySearchUsingRecursion(arr, x, s, mid-1);
		}		
	}
	
	
	public static boolean checkSortedArray(int arr[], int idx) {
		
		// base case
		if(arr.length == 0 || arr.length == 1)
			return true;
		
		boolean isSorted = false;
		
		if(idx < arr.length-1 && (arr[idx] < arr[idx+1]))
			isSorted = true;
		else {
			isSorted = false;
			return false;
		}
		
		checkSortedArray(arr, idx+1);
		
		return isSorted;
	}
	
	public static int sumOfArray(int arr[], int idx, int sum) {
		
		// base case
		if(idx == arr.length || arr.length == 0)
			return sum;
		
		sum += arr[idx];
		
		sum = sumOfArray(arr, idx+1, sum);
		
		return sum;
		
	}
	
	public static boolean linearSearch(int arr[], int key, int idx) {
		
		boolean isFound = false;
		
		// base case
		if(arr[idx] == key) {
			isFound = true;
			return isFound;
		}
		
		isFound = linearSearch(arr, key, idx+1);
		
		return isFound;
	}
	
	
	public static String reverseString(String str, int s, int e, String revStr) {
		
		if(str.isEmpty() || str.length() == 1) {
			return str;
		}
		
		return (str.substring(1) + str.charAt(0));
	}
	
	
	public static boolean isPalindrome(String str, int s, int e) {
		
		
		boolean isPalin = true;
		
		if(s >= e)
			return isPalin;
		
		
		if(str.charAt(s) != str.charAt(e))
			return false;
		
		isPalin = isPalindrome(str,s+1,e-1);
		
		return isPalin;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(findPower(2, 4));
		
		System.out.println(findFactorial(5));
		
		printCountingUptoN(10);
		
		System.out.print("\n");
		
		System.out.println(fibonacciSeries(7));
		
		System.out.println(distinctWaysOfClimbingStairs(5));
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6,  "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		
		sayDigit(2243653,map);
		System.out.println();
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(binarySearchUsingRecursion(arr,8, 0, arr.length-1));
		
		int unSortedArr[] = {4,2,7,4,7,7,8,0};
		
		System.out.println("Is Array Sorted? " + checkSortedArray(arr, 0));
		
		System.out.println("Sum of Array Elements is: " + sumOfArray(unSortedArr, 0, 0));
		
		int key = 0;
		System.out.println("Is " + key + " found in the array? " + linearSearch(unSortedArr, key, 0));
		
		String str = "Tanishq";
		System.out.println("Reversed String is: " + reverseString(str, 0, str.length()-1, ""));
		
		String palinStr = "abbbba";
		System.out.println("Is String " + palinStr + " a Palindrome? "+isPalindrome(palinStr,0,palinStr.length()-1));
		
	}

}
