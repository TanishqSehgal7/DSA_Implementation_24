package Stacks;

public class TwoStacks {
	
	static int arr[];
	static int top1;
	static int top2;
	static int size1;
	static int size2;
	
	public TwoStacks(int size1, int size2) {
		this.top1 = -1;
		this.top2 = size1-1;
		this.size1 = size1;
		this.size2 = size2;
		this.arr = new int[size1+size2];
	}
	
	public static boolean is1Full() {
		return top1>=size1-1;
	}
	
	public static boolean is2Full() {
		return top2>=(size1+size2-1);
	}
	
	public static boolean is1Empty() {
		return top1==-1;
	}
	
	public static boolean is2Empty() {
		return top2==size1-1;
	}
	
	public static void push1(int data) {
		
		if(is1Full()) {
			System.out.println("Stack 1 Overflow!");
		} else {
			arr[++top1] = data;
			return;
		}
	}
	
	public static void push2(int data) {
		
		if(is2Full()) {
			System.out.println("Stack 2 Overflow!");
		} else {
			arr[++top2] = data;
			return;
		}
	}
	
	public static void pop1() {
		
		if(is1Empty()) {
			System.out.println("Stack 1 Underflow!");
		} else {
			arr[top1] = -1;
			top1-=1;
		}
	}
	
	public static void pop2() {
		if(is2Empty()) {
			System.out.println("Stack 2 Underflow!");
		} else {
			arr[top2] = -1;
			top2-=1;
		}
	}
	
	public static void printStack() {
		
		for(int i=0;i<size1+size2;i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoStacks ts = new TwoStacks(5,5);
		
		ts.push1(10);
		ts.push1(20);
		ts.push1(30);
		ts.push2(40);
		ts.push2(50);
		ts.push2(60);
		
		printStack();
		System.out.println("\n");
		
		System.out.println("Top1 " + arr[top1]);
		System.out.println("Top2 " + arr[top2]);
	}

}
