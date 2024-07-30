package Queue;

public class NQueuesInArray {
	
	static int size;
	static int k;
	static int front[];
	static int rear[];
	static int arr[];
	static int freeSpot;
	static int next[];
	
	
	public NQueuesInArray(int size, int k) {
		
		this.size = size;
		this.k = k;
		front = new int[k];
		rear = new int[k];
		arr = new int[size];
		freeSpot = 0;
		next = new int[size];
		
		for(int i=0;i<k;i++) {
			front[i] = -1;
			rear[i] = -1;
		}
		
		for(int i=0;i<size;i++) {
			next[i] = i+1;
		}
		next[size-1] = -1;
	}
	
	public static void enQueue(int data, int qNumber) {
		
		// overflow condition
		if(freeSpot == -1) {
			System.out.println("No Empty space is available in Queue!");
			return;
		}
		
		// find first free index
		int index = freeSpot;
		
		// update freespot
		freeSpot = next[index];
		
		// check whether first element
		if(front[qNumber-1] == -1) {
			front[qNumber-1] = index;
		} else {
			// link new element rear to previous element rear
			next[rear[qNumber-1]] = index;
		}
		
		// update next
		next[index] = -1;
		
		// update rear
		rear[qNumber-1] = index;
		
		// push element
		arr[index] = data;
		
	}

	public static void main(String[] args) {

		
		
	}

}
