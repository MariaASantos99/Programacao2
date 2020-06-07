public class Room {
	private Point cie,csd;
	private String divisao;
	
	public Room(Point cie, Point csd, String divisao){
		this.cie = cie;
		this.csd = csd;
		this.divisao = divisao;
	}
	
	public String roomType(){
		return divisao;
	}
	
	public Point bottomLeft(){
		return cie;
	}
	
	public Point topRight(){
		return csd;
	}
	
	public Point geomCenter(){
		return this.cie.halfWayTo(this.csd);
	}
	
	public double area() {
		Point defineSide = new Point(csd.x(),cie.y());
		return cie.distTo(defineSide)*csd.distTo(defineSide);
	}
}

