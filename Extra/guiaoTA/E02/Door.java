
public class Door {

	// Declare necessary fields here...
	private int room1, room2;
	private double width, height;
	/** Constructs a new Door between two rooms.
	* @param r1 Identifier of a room.
	* @param r2 Identifiier of another room.  It cannot be the same as r1!
	* @param w  Door width (in meters).  Must be positive.
	* @param h  Door height (in meters).  Must be positive.
	*/
	public Door(int r1, int r2, double w, double h) {
		assert r1 != r2; 
		assert w >0 && h>0;
		room1 = r1;
		room2 = r2;
		width = w;
		height = h;
	}
	public int r1(){
		return this.room1;
	}
	public int r2(){
		return this.room2;
	}
	public double area(){
		return width*height;
	}

}

