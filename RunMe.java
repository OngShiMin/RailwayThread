// Main Method
public class RunMe {

	public static void main(String[] args) {
//		create the railway
		Station glasgow = new Station("Glasgow", 5);
		Track t1 = new Track(2000);
		Station stirling = new Station("Stirling", 2);
		Track t2 = new Track(5000);
		Station perth = new Station("Perth", 3);
		Track t3 = new Track(3000);
		Station dundee = new Station("Dundee", 4);
		
//		 all segment objects have a 'next' attribute
//		 that points to the next segment (track or train)
//		 Glasgow >> track >> Stirling >> track >> Perth >> track >> Dundee
		glasgow.setNext(t1);
		t1.setNext(stirling);
		stirling.setNext(t2);
		t2.setNext(perth);
		perth.setNext(t3);
		t3.setNext(dundee);
		
//		 finish the railway with a sink after last station
		dundee.setNext(new TrainSink());
		
		
//		 create a thread that will inject trains into Glasgow Station
		new Thread(new TrainMaker(glasgow)).start();
		
		
//		 make a printer 
//		 note: 
//		 	only need the first segment, 
//		 	and iterates through using the 'next' method
		new Thread(new RailwayPrinter(glasgow)).start();
	}

}
