public class SpinningDiskDevice 
{
   private int lastInput;
   private int segmentLength;

   /**
      Constructs a spinning disk device.
   */
   public SpinningDiskDevice()
   {
      lastInput=-1;
      segmentLength=0;
   }

   /**
      Processes a new input
      @param input 0 or 1
   */
   public void add(int input)
   {
      if(lastInput==input)segmentLength++;
      else{
         segmentLength=1;
         lastInput=input;
      }
      
   }

   /**
      Gets the length of the current segment.
   */
   public int getSegmentLength()
   {
      return this.segmentLength;
   }
   
   public static void main(String[] args)
   {
      SpinningDiskDevice device = new SpinningDiskDevice();
      System.out.println(device.getSegmentLength());
      System.out.println("Expected: 0");
      device.add(0);
      device.add(0);
      device.add(0);
      System.out.println(device.getSegmentLength());
      System.out.println("Expected: 3");
      device.add(0);
      System.out.println(device.getSegmentLength());
      System.out.println("Expected: 4");
      device.add(1);
      System.out.println(device.getSegmentLength());
      System.out.println("Expected: 1");
      device.add(1);
      device.add(1);
      device.add(1);
      device.add(1);
      device.add(1);
      device.add(1);
      System.out.println(device.getSegmentLength());
      System.out.println("Expected: 7");
      device.add(0);
      System.out.println(device.getSegmentLength());
      System.out.println("Expected: 1");
   }
}

