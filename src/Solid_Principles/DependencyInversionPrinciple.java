package Solid_Principles;

public class DependencyInversionPrinciple {
	
	interface Keyboard {
	    String type();
	}

	public static class MechanicalKeyboard implements Keyboard {
	    
		@Override
	    public String type() {
	        return "Mechanical keyboard";
	    }
	}
	
	public static class MembraneKeyboard implements Keyboard {
		
		@Override
		public String type() {
			return "Membrane Keyboard";
		}
	}

	public static class WindowsPC {
	    
		private Keyboard keyboard;

	    public WindowsPC(Keyboard keyboard) {
	        this.keyboard = keyboard;
	    }
	    
	    public void printPcComponents() {
	    	System.out.println("This PC uses " + keyboard.type());
	    }
	}
	
	public static void main(String[] args) {
		
		MechanicalKeyboard mechkb = new MechanicalKeyboard();
		WindowsPC pc1 = new WindowsPC(mechkb);
		
		mechkb.type();
		pc1.printPcComponents();
		
		
		MembraneKeyboard membKb = new MembraneKeyboard();
		WindowsPC pc2 = new WindowsPC(membKb);
		
		membKb.type();
		pc2.printPcComponents();
		
	}
}