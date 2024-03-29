public class Box
{
   private double height;
   private double width;
   private double depth;

   /**
      Constructs a box with a given side length.
      @param sideLength the length of each side
   */   
   public Box(double h, double w, double d)
   {
      height=h;
      width=w;
      depth=d;
   }

   /**
      Gets the volume of this box.
      @return the volume
   */
   public double volume()
   {
      return height*width*depth;
   }
   
   /**
      Gets the surface area of this box.
      @return the surface area
   */
   public double surfaceArea()
   {
      return (2*height*width)+(2*height*depth)+(2*depth*width);
   }
}

