public class Square{
	private double length;
	/**
	 * Constructor a square with a given side length
	 * @param sideLength the length of each side
	 */
	public Square(double sideLength){
		length = sideLength;
	}
	
	/**
	 * Return the area of this square
	 * @return the area
	 */
	 public double area(){
		 return length*length;
	 }
	 
	 /**
	  * Grows the side length of this square
	  * @param percentage the percentage by which to grow the square
	  * (for example: 10 if the square is to be grown by 10%)
	  */
	 public void grow(double percentage){
		 length += length*percentage/100;
	}
	
	//This method is used for checking your work. Do not modify it.
	public static double check(double s, double p){
		Square sq = new Square(s);
		sq.grow(p);
		return sq.area();
	}
	public static void main(String []args){
		double value = check(10,20);
		System.out.println(value);//Expected 144.0
		value = check(10,-20);
		System.out.println(value);//Expected 64.0
		value = check(10,0);
		System.out.println(value);//Expected 100.0
	}
}

