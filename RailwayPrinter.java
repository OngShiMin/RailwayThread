// Class that defines a railway printer
// 'view' in MVC
// Implements runnable

public class RailwayPrinter implements Runnable {
	private Segment start;
	public RailwayPrinter(Segment start) {
		this.start = start;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000); // prints 1 line per second
				String output = "";
				Segment current = start;
				do {
					// Synchronized block avoids concurrent arraylist modification errors
					synchronized(current) {
						output += current.toString();
						current = current.getNext();
					}
					
				}while(current.getNext() != null); 
				System.out.println(output);
					
				}catch(InterruptedException e) {
					e.printStackTrace();
			}
		}
	}
}
