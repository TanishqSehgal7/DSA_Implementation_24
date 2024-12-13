package Solid_Principles;

public class InterfaceSegregation {
	
	interface FlyableVehicle {
		void fly();
	}
	
	interface DrivableVehicle {
		void drive();
	}
	
	public static class Car implements DrivableVehicle {

		@Override
		public void drive() {
			System.out.println("Engine Started! You can drive the Car.");
		}
	}
	
	public static class Plane implements FlyableVehicle, DrivableVehicle {

		@Override
		public void drive() {
			System.out.println("Engine started! You can drive the "
					+ "plane through the runway!");
		}
		
		@Override
		public void fly() {
			System.out.println("We have taken off and "
					+ "the plane is flying now.");
		}
		
	}
	
	public static void main(String[] args) {
		
		Car car = new Car();
		car.drive();
		
		Plane plane = new Plane();
		plane.drive();
		plane.fly();
	}

}
