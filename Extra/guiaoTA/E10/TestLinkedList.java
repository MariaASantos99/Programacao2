
import static java.lang.System.*;
import java.io.*;
import p2utils.*;

public class TestLinkedList
{

  public static void main(String[] args) throws IOException
  {
    LinkedList<Integer> lst = new LinkedList<Integer>();

    for(int i=0; i<7; i++) {
      lst.addFirst(i);
      lst.addFirst(myRandom(8));
      lst.addLast(100+i);
    }

    out.println(lst.toString());

    //~ out.println(lst.countR(5));
    //~ out.println(lst.countI(5));

    //~ out.println(lst.cloneReplace(5,99));  //.toString() implícito!
    //~ out.println(lst.cloneReplaceI(5,99));  //.toString() implícito!
	
    //~ out.println(lst.indexOf(5));
    //~ out.println(lst.indexOfI(5));

    //~ out.println(lst.indexOf(50000));
    //~ out.println(lst.indexOfI(50000));

    out.println(lst.cloneSublist(7,14));
    //~ out.println(lst.cloneSublistI(7,14));

    out.println(lst.cloneExceptSublist(7,14));
    //~ out.println(lst.cloneExceptSublistI(7,14));
	out.println();
    lst.removeSublist(7,14);
    out.println(lst);
    out.println(lst.size());
    out.println(lst.last());

    lst.removeSublist(12,14);
    out.println(lst);
    out.println(lst.size());
    out.println(lst.last());
    
    lst.removeSublist(0,2);
    out.println(lst);
    out.println(lst.size());
    out.println(lst.last()); 
  }   

  static int myRandom(int n) {
    return (int)(Math.random()*n);
  }
}

