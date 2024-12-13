package Solid_Principles;

public class LiskovSubstituion {

	public static abstract class Bird {
		
		public abstract void makeSound();
	}
	
	interface FlyableBird {
		void fly();
	}
	
	interface WalkableBird {
		void walk();
	}
	
	public static class Sparrow extends Bird implements FlyableBird {

		@Override
		public void fly() {
			System.out.println("Sparrow is a flyable bird.");
		}

		@Override
		public void makeSound() {
			System.out.println("Chirp Chirp!");
		}
	}
	
	public static class Penguin extends Bird implements WalkableBird {

		@Override
		public void makeSound() {
			System.out.println("Squawk!");
		}

		@Override
		public void walk() {
			System.out.println("Penguin is Walking!");
		}
	}
 	
	public static void main(String[] args) {
		
		Sparrow sparrow = new Sparrow();
		sparrow.makeSound();
		sparrow.fly();
		
		Bird penguin = new Penguin(); // liskov substitution
		penguin.makeSound();
		
		Penguin walkingPenguin = new Penguin();
		walkingPenguin.walk();
	}
}
