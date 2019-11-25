
public class Train implements Runnable{
	private final int speed;
	private final String name;
	private Segment currSegment;
	private Segment nextSegment;
	
	public Train(int speed, String name, Segment start) {
		this.speed = speed;
		this.name = name;
		this.currSegment = start;
	}
	
	public void run() {
		while(true) {
			// sleep time based on length of current segment
			int sleepTime = currSegment.getLength()/speed;
			try {
				Thread.sleep(sleepTime);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			// enter next segment
			nextSegment = currSegment.getNext();
			
			// check condition that, if in sink:
			if(nextSegment == null) {
				currSegment.leave(this);
				break;
			}
			
			// if not in sink, enter next
			nextSegment.enter(this);
			// leave current segment
			currSegment.leave(this);
			// update current segment to new one
			currSegment = nextSegment;
		}
	}
	
	public String toString() {
		return this.name;
	}

}
