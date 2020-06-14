public class Person{

   /**
      Constructs a person. 
      @param aName the person's name
      @param aStreet the street
      @param aCity the city
      @param aState the two-letter state code
      @param aZip the ZIP postal code
   */
   public Person(String aName, Address personAddress)
   {  
      name = aName;
      address = personAddress.format();
   }   

   /**
      Formats the person's name and address for mailing.
      @return a string suitable for printing on a mailing label
   */
   public String formatForMailing()
   {  
      return name +"\n"+address;
   }
   
   private String name;
   private String address;
   
   // This method is used for checking your work. Do not modify it

   public static void main(String[] args)
   {
      Person harry = new Person("Harold J. Hacker",
         new Address("123 Main Street", "Anytown", "NY", "12345"));
      System.out.println(harry.formatForMailing());
   }   
}
