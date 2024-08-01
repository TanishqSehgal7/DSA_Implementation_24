package Stacks;

public class NStacks {

	static int N;
	static int K;
	static int sN;
	static int arr[];
	static int next[];
	static int top[];
	static int freeSpot;
	
	public NStacks(int n, int k) {
		this.N = n;
		this.K = k;
		this.arr = new int[N];
		this.next = new int[K];
		this.top = new int[K];
		
		// initialize arr with all -1s
		for(int i=0;i<N;i++) {
			arr[i] = -1;
		}
		
		// initialize top with all -1s and next with next free index in arr
		for(int i=0;i<k;i++) {
			top[i] = -1;
			next[i] = i+1;
		}
		// iniitlize last index in next as -1 since there is no next slot for last element in arr
		next[K-1] = -1;
		
		// initialize freeSpot
		freeSpot = 0;
	}
	
	public static boolean push(int data, int sN) {
		
		// check for overflow condition
		if(freeSpot == -1) {
			System.out.println("Stack Overflow!");
			return false;
		}
		
		// find index
		int index = freeSpot;
		
		// update freeSpot
		freeSpot = next[index];
		
		// insert at index
		arr[index] = data;
		
		// update next
		next[index] = top[sN-1];
		
		// update top
		top[sN-1] = index;
		
		return true;
	}
	
	public static int pop(int sN) {
		
		// check for underflow condition
		if(top[sN-1] == -1) {
			System.out.println("Stack Underflow!");
			return -1;
		}
		
		// find index of top
		int index = top[sN-1];
		
		// update top
		top[sN-1] = next[index];
		
		// update next
		next[index] = freeSpot;
		
		// update freeSpot
		freeSpot = index;
		
		arr[index] = -1;
		
		return arr[index];
	}
	
	
	public static void main(String[] args) {
		
		
	}

}
