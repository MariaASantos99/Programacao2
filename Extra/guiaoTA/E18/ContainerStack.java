//NMEC: 87965
//NOME: Maria Alves Santos
import static java.lang.System.*;

public class ContainerStack {
  private Container[] array;
  private int size;  
  
  public ContainerStack(int maxSize) {
    assert maxSize >= 0;
    array = new Container[maxSize];
    //size = 0;
    assert isEmpty();
  }
  
  public void push(Container e) {
    assert !isFull();
    array[size] = e;
    size++;
    e.incrementOps();
    assert !isEmpty() && top() == e;
  }
  
  public void pop() {
    assert !isEmpty();
    --size;
    array[size] = null;
    assert !isFull();
  }
  
  public Container top() {
    assert !isEmpty();
    return array[size-1];
  }
  
  public boolean isEmpty() { return size==0; }
  
  public boolean isFull() { return size==array.length; }
  
  public int size() { return size; }
  
  public void clear() {
    size = 0;
    array = new Container[array.length];
    assert isEmpty();
  }
  
  /**
   * Search for a container with a given type of cargo.
   * @param type the type of cargo we're looking for
   * @return 0 if the desired container is on the top,
   *         1 if it is under 1 container, etc
   *        -1 if not found
   */
  public int search(String type) {
    for (int i = 0; i < size; i++) {
      if (array[size-1-i].contains(type)) return i;
    }
    return -1;
  }
  
  /**
   * Merge two sorted subvectors: a[start..middle[ with a[middle..end[
   */
  private static void mergeSubarrays(Container[] a,int start,int middle,int end) 
  {
    Container[] b = new Container[end-start];
    int i1 = start;
    int i2 = middle;
    int j = 0;
    while(i1 < middle && i2 < end) {
      if (a[i1].id < a[i2].id)
        b[j++] = a[i1++];
      else
        b[j++] = a[i2++];
    }
    while(i1 < middle)
      b[j++] = a[i1++];
    while(i2 < end)
      b[j++] = a[i2++];
    arraycopy(b, 0, a, start, end-start);
  }

  //...
	public String toString(){
		String s= "";
		for (int i = 0; i < size; i++){
			s += array[i].toString();
			if(i < size-1)s += ",";
		}
		return s;
	}
	
	
  public int searchRec(String type){
	  return searchR(type, array.length-1);
  }
  
  private int searchR(String type, int idx){
	  if(idx<0) return -1;
	  if(array[idx].contains(type)) return array.length-1-idx;
	  return searchR(type, idx-1);
  }
  
  public static void sort(Container[] a, int start, int end){
	  if(end-start>1){
		  int middle = (start+end)/2;
		  sort(a, start, middle);
		  sort(a, middle, end);
		  mergeSubarrays(a, start, middle, end);
	  }
  }
  
  public Container[] containersInStack(){
	  Container[] c = new Container[array.length];
	  System.arraycopy(array, 0, c, 0, size);
	  sort(c, 0, c.length);
	  return c;
  }
		
	
}

