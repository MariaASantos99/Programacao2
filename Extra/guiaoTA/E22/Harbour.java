
import static java.lang.System.*;
import pt.ua.p2utils.*;

public class Harbour {

  private final Dock[] docks;
  private final int maxStack;
  private final HashTable<Integer> ht;

  public Harbour(int nOfDocks,int maxStack) {

    docks = new Dock[nOfDocks];
    for (int dockId=0; dockId<nOfDocks; dockId++) {
      docks[dockId] = new Dock(maxStack);
    }
    this.maxStack = maxStack;
    ht = new HashTable<>(100);
  }        

  public boolean stackEmpty(int dockId) {
    return docks[dockId].stackEmpty();
  }

  public boolean stackFull(int dockId) {
    return docks[dockId].stackFull();
  }

  public boolean accessExtensionEmpty(int dockId) {
    return docks[dockId].accessExtensionEmpty();
  }

  public void displayDocks() {
    for (int dockId=0; dockId<docks.length; dockId++) {
      out.println(dockId+": "+docks[dockId]);
    }
  }

  public void enterContainer(int dockId,Container c) {
    docks[dockId].enterContainer(c); // implement in the Dock class
    //...
    int count=0;
	if(ht.contains(c.destination)) {count = ht.get(c.destination);}
	ht.set(c.destination, count+1);
  }

  public void moveFromAccessToStack(int dockId) {
    docks[dockId].moveFromAccessToStack(); // implement in the Dock class
  }

  // the container on top of the stack in the given dock
  // is removed because it will be shipped
  public Container shipContainer(int dockId) {
    Container c = docks[dockId].shipContainer(); //implement in the Dock class
    //...
	int count = ht.get(c.destination);
	count--;
	if(count==0) ht.remove(c.destination);
	else ht.set(c.destination, count);
    return c;
  }

  // total number of containers
  public int count() {
    //..
    int count =0;
    for (int i = 0; i < docks.length; i++) {count += docks[i].count();}
	return count;
  }

  // number of containers for a given destination
  public int countToDestination(String destin) {
    //...
	return ht.get(destin);
  }

  // array containing destinations of existing containers
  public String[] currentDestinations() {
    //...
	return ht.keys();
  }

  // given a dock, picks the first container
  // in the queue and inserts in the stack of the same dock
  public void insertFirstInStack(int dockId) {
    docks[dockId].insertFirstInStack(); // implement in the Dock class
  }
}

