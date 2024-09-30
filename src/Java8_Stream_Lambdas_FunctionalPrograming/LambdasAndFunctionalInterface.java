package Java8_Stream_Lambdas_FunctionalPrograming;

public class LambdasAndFunctionalInterface {

	/* THIS IS THE OLDER WAY OF DEALING WITH INTERFACES
	*/
	
	public static void main(String[] args) {
		
		
//		Walkable walk = new Walkable() {
//
//			@Override
//			public int walk(int steps) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		}; // Anonymous class
		
//		Walkable walkable = new WalkFast();
//		walkable.walk(5);
		
		Walkable obj = (steps, isEnabled) -> {
			
			if(isEnabled) {
				steps *= 2;
				System.out.println("Walking Fast "  + steps + " steps.");
			} else {
				steps = -1;
				System.out.println("Walking Disabled. Total steps = " + steps);
			}
			return steps;
		}; // functional interface
		
		/*
		Functional interface is an interface that contains exactly one 
		abstract method. It can have multiple default and static methods
		but only one abstract method. Functional interfaces are a key feature of 
		lambda expressions in Java, which allow you to provide implementations 
		of the single abstract method in a concise manner.
		
		Functional interfaces were introduced in Java 8, and the @FunctionalInterface 
		annotation is typically used to indicate that an interface is intended to be a 
		functional interface, though it's optional. If the interface marked with this 
		annotation has more than one abstract method, the compiler will throw an error.
		
		The functional interface contains only one abstract method, which can be 
		implemented via lambda expressions or method references. Functional interface
		facilitates functional programming in java and gives better abstraction.
		
		*/
		
		obj.walk(5, true);
		
		Run run = (speed) -> {
			System.out.println("Running speed is: " + speed + " Km/hr");
			return speed;
		};
		
		run.runningSpeed(8);
		
		// single line implementation of a lambda expression
		Walkable obj2 = (steps, isEnabled) -> 2*steps;
		System.out.println(obj2.walk(3, true));
	}

}

interface Walkable {
	int walk(int steps, boolean isEnabled);
}


@FunctionalInterface
interface Run {
	int runningSpeed(int speed);
}


//class WalkFast implements Walkable {
//
//	@Override
//	public int walk(int steps) {
//		// TODO Auto-generated method stub
//		System.out.println("Walking Fast "  + steps + " steps.");
//		return 2*steps;
//	}
	
//}