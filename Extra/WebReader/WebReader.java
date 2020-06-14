import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebReader{
   public static boolean checkURL(String site)
   {
      URL u = new URL(site);
      Scanner in = new Scanner(u.openStream());
      return in.hasNextLine();
   }

   // This method checks your work. Do not modify it.

   public static String check(String site)throws IOException,MalformedURLException
   {
      try
      {
         if (checkURL(site))
            return "good";
         else
            return "empty";
      }
      catch (MalformedURLException ex)
      {
         return "bad URL";
      }
      catch (Exception ex)
      {
         return "bad";
      }
   }
}
