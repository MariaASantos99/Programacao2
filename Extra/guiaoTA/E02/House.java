
import static java.lang.System.*;

public class House {

  public House(String houseType,int maxSize,int extensionSize) {
    this.houseType = houseType;
    this.extensionSize = extensionSize;
    rooms = new Room[maxSize];
    size = 0;
    doors = new Door[maxSize];
    numDoors = 0;
  }

  public House(String houseType) {
    this(houseType,8,4);
  } 

  public int size() {
    return size;
  }

  public int maxSize() {
    return rooms.length;
  }

  public Room room(int i) {
    return rooms[i];
  }

  public int addRoom(Room r) {
    if (size == rooms.length) extendHouse();
    rooms[size] = r;
    size++;
    return size-1;
  }

  private void extendHouse() {
    Room [] newRooms = new Room[rooms.length+extensionSize];
    arraycopy(rooms, 0, newRooms, 0, rooms.length);
    rooms = newRooms;
  } 

  private String houseType;
  private int extensionSize;
  private Room [] rooms;
  private int size;
  private Door [] doors;
  private int numDoors;

  public void addDoor(Door d) {
	if(maxNumDoors() == numDoors()){
		Door[] newdoors = new Door[doors.length+extensionSize];
		arraycopy(doors, 0, newdoors, 0, doors.length);
		doors = newdoors;
	}
    doors[numDoors] = d;
    numDoors++;
  }

  public int numDoors() {
    return numDoors;
  }

  public int maxNumDoors() {
    return doors.length;
  }

  public int roomClosestToRoomType(String roomType){
	int i, idx=0;
	for (i = 0; i < size; i++){
		if(roomType.equals(rooms[i].roomType()))break;
	}
	if(i!=size){
		for (int j = 1; j < size; j++){
			if(i == idx)idx = 1;
			if(i != j && i!= idx){
				double k1 = rooms[i].geomCenter().distTo(rooms[idx].geomCenter());
				double k2 = rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				if(k1>k2)idx = j;
			}
		}	
	}		
	return idx; 	  
  }
  
  /**
   * @return máximo número de portas numa qualquer divis˜ao da habitaç˜ao.
   */
  public int maxDoorsInAnyRoom(){
	  int idx=0;
	  int[] ndoors = new int[size];
	  for (int i = 0; i < numDoors; i++){
		  ndoors[doors[i].r1()]+=1;
		  ndoors[doors[i].r2()]+=1;
	  }
	  for (int i = 1; i < numDoors; i++){
		  if(ndoors[idx]<ndoors[i])idx=i;		  
	  } 
	  return ndoors[idx];
  }
  

}

