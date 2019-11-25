// Class that goes at the end to remove the trains from the railway
// Extends segment so that it can be assigned to the 
// 'next' attribute of the last visible track

public class TrainSink extends Segment{
	// these go at the end and trains will be removed
	public TrainSink() {
		super(0, 0, "");
	}
	
	
	// override enter and leave, as we don't
	// care what happens when trains enter or 
	// when they leave
	public void enter(Train t) {
		//nothing
	}
	public void leave(Train t) {
		//nothing
	}
	
	
	public String toString() {
		return "";
	}

}
