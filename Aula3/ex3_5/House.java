public class House{
	private String houseType;
	private int nrooms=0, extrarooms=0, roomsCount=0;
	private Room[] allRoom = new Room[10000];
	public House(String houseType){
		if(houseType.equals("house") || houseType.equals("apartment"))this.houseType=houseType;
		else System.out.println("Não é valido!");
		nrooms=8;
		extrarooms=4;
	}
	
	public House(String houseType, int nrooms, int extrarooms){
		if(houseType.equals("house") || houseType.equals("apartment"))this.houseType=houseType;
		else System.out.println("Não é valido!");
		this.nrooms = nrooms;
		this.extrarooms = extrarooms;
		
	}
		
	public void addRoom(Room newRoom) {
		if(roomsCount==nrooms-1)nrooms+=extrarooms;
		allRoom[roomsCount++] = newRoom;
	}
		
	public int size(){
		return roomsCount;
	}
	
	public int maxSize(){
		return nrooms;
	}

	public Room room(int indice){
		assert(indice>=0 && indice <roomsCount-1);
		return allRoom[indice];
	}

	public double area(){
		double soma = 0;
		for (int i = 0; i < roomsCount; i++){
			soma += allRoom[i].area();
		}
		return soma;
	}
	
	public RoomTypeCount[] getRoomTypeCounts() {
		int k=0;
		int[] help = new int[roomsCount];
		int[] name = new int[roomsCount]; 
       
        for (int i = 0; i < roomsCount; i++){
            name[i] +=1;
            for (int j = i+1; j < roomsCount; j++){
                if (allRoom[i].roomType().equals(allRoom[j].roomType())) {
                    k++;
                    help[j] = 1;
                    name[i] += 1;
                }
            }
        }
        RoomTypeCount[] r = new RoomTypeCount[roomsCount-k];
        k=0;
   
        for (int i = 0; i < roomsCount; i++){
            if (help[i] != 1) {
                r[k] = new RoomTypeCount();
                r[k].roomType = allRoom[i].roomType();
                r[k].count = name[i];
                k++;
            }
        }
		return r;
	}
	
	public double averageRoomDistance(){
		double soma=0,count=0;
		for (int i = 0; i < roomsCount-1; i++){
			for (int j = i+1; j < roomsCount; j++){
				Point a= allRoom[i].geomCenter();
				Point b= allRoom[j].geomCenter();
				soma += a.distTo(b);
				count++;
			}
		}
		double dist=soma/count;	
		return dist;
	}
	
}
