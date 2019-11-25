import java.util.Random;
// Creates train
// extends segment but with no capacity
// i.e there can be as many trains waiting here
// overrides the leave method as nothing 
// needs to be done when a train leaves here

public class TrainMaker extends Segment implements Runnable{
	// makes trains that then try to enter 'next'
	private final Random r = new Random();
	private static int trainNumber = 1;
	public TrainMaker(Segment next) {
		super(0, 0, "");
		super.setNext(next);
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(r.nextInt(1000));
				int speed = r.nextInt(2) + 1;
				// created a new train passing 'this' as the starting segment
				Train t = new Train(speed, ""+trainNumber, this);
				new Thread(t).start();
				trainNumber += 1;
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void leave(Train t) {
		//do nothing
	}
	

}
