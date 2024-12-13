package Solid_Principles;

public class SingleResponsibility {

	public static class Invoice {
		
		private String item;
		private double price;
		
		public Invoice(String item, double price) {
			this.item = item;
			this.price = price;
		}
		
		public double calculateTotalPriceWithGst() {
			return this.price * 1.18;
		}
		
		public String getItem() {
			return item;
		}
		
		public double getPrice() {
			return price;
		}
 	}
	
	public static class InvoiceDatabase {
		
		public void saveToDatabase(Invoice invoice) {
			System.out.println("Invoice for " + invoice.getItem() + " saved to database");
		}
	}
	
	public static class InvoicePrinter {
		
		public void printInvoice(Invoice invoice) {
			System.out.println("Printing invoice: " + invoice.getItem() + 
					", Total: " +  invoice.calculateTotalPriceWithGst());
		}
	}
	
	public static void main(String[] args) {
		
		Invoice invoice = new Invoice("MacBook Pro - 16 inch", 150000);
		InvoiceDatabase db = new InvoiceDatabase();
		InvoicePrinter printer = new InvoicePrinter();
		
		db.saveToDatabase(invoice);
		printer.printInvoice(invoice);
	}
	
}