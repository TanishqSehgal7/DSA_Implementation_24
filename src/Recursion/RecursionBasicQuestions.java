package Recursion;

public class RecursionBasicQuestions {
	
	public static int findPower(int x, int n) {
		
		if(n == 0) {
			return 1;
		}
		
		if(n == 1) {
			return x;
		}
		
		return x * findPower(x, n-1);
		
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(findPower(2, 4));
		
		System.out.println(findFactorial(5));
		
		printCountingUptoN(10);
		
		System.out.print("\n");
		
		System.out.println(fibonacciSeries(7));
		
		System.out.println(distinctWaysOfClimbingStairs(3));
	}

}
