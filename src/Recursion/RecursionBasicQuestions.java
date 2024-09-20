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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(findPower(2, 4));
		
		System.out.println(findFactorial(5));
	}

}
