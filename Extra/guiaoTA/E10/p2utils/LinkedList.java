package p2utils;

public class LinkedList<E extends Comparable <E>> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /** {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

  /** Returns the number of elements in the list.
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /** Returns the first element in the list.
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";

    return first.elem;
  }

  /** Returns the last element in the list.
   * @return Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }

  /** Adds the given element to the start of the list.
   * @param e the element to add
   */
  public void addFirst(E e) {
    first = new Node<>(e, first);
    if (isEmpty())
      last = first;
    size++;

    assert !isEmpty(): "empty!";
    assert first().equals(e) : "wrong element";
  }

  /** Adds the given element to the end of the list.
   * @param e the element to add
   */
  public void addLast(E e) {
    Node<E> newest = new Node<>(e);
    if (isEmpty())
      first = newest;
    else
      last.next = newest;
    last = newest;
    size++;

    assert !isEmpty(): "empty!";
    assert last().equals(e) : "wrong element";
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /** Removes all elements.
   */
  public void clear() {
    first = last = null;
    size = 0;
  }

  /** Returns a string representing the list contents.
   * @return A string representing the list contents
   */
  public String toString() {
    String sep = "";
    String s = "";
    for (Node<E> n = first; n != null; n = n.next) {
      s += sep + n.elem;
      sep = ", ";
    }
    return "[" + s + "]";
  }

  // funcoes adicionais pedidas no guião...
	//função recursiva do count
	public int countR(E e){
		return countR(e, first);
	}
	
	private int countR(E e, Node<E> n){
		if(n == null) return 0;
		else if(e.compareTo(n.elem)== 0)return 1+countR(e, n.next);
		return countR(e, n.next);
	}
	//função iterativa do count
	public int countI(E e){
		int count = 0;
		for(Node<E> n=first; n!=null; n=n.next){
			if(e.compareTo(n.elem)==0)count++;
		}
		return count;
	}
	
	//função recursiva do indexOf
	public int indexOf(E e){
		return indexOf(e, first, 0);
	}
	
	private int indexOf(E e,Node<E> n, int i){
		if(n== null)return -1;
		else if(e.compareTo(n.elem)==0)return i;
		return indexOf(e,n.next,i+1);		
	}
	//função iterativa do indexOf
	public int indexOfI(E e){
		int idx = -1;
		Node<E> n;
		for (n = first; n != null; n=n.next){
			idx++;
			if(e.compareTo(n.elem)==0)break;
		}
		if(n==null)idx=-1;
		return idx;		
	}
	
	//função recursiva
	public LinkedList<E> cloneReplace(E x, E y){
		return cloneReplace(x, y, first);
	}
	
	private LinkedList<E> cloneReplace(E x, E y, Node<E> n){
		if(n==null)return new LinkedList<E>();
		LinkedList<E> clone = cloneReplace(x, y, n.next);
		if(n.elem.equals(x))clone.addFirst(y);
		else clone.addFirst(n.elem);
		return clone;
	}
	//funçao iterativa
	public LinkedList<E> cloneReplaceI(E x, E y){
		LinkedList<E>clone = new LinkedList<E>();
		for (Node<E> n = first; n!=null; n=n.next){
			if(x.equals(n.elem))clone.addLast(y);
			else clone.addLast(n.elem);
		}
		return clone;
	}
	
	//função recursiva
	public LinkedList<E> cloneSublist(int start, int end){
		return cloneSublist(start, end, first, 0);
	}
	
	private LinkedList<E> cloneSublist(int start, int end, Node<E> n, int idx){
		if(n == null || idx>end)return new LinkedList<E>();
		LinkedList<E> ls = cloneSublist(start,end, n.next,idx+1);
		if(start<= idx && idx<end)ls.addFirst(n.elem);
		return ls;
	}
	//função iterativa
	public LinkedList<E> cloneSublistI(int start, int end){
		LinkedList<E>ls = new LinkedList<E>();
		int idx=-1;
		for (Node<E> n = first; n!=null; n=n.next){
			idx++;
			if(idx>=start && idx < end)ls.addLast(n.elem);
		}
		return ls;
	}
	
	//função recursiva
	public LinkedList<E> cloneExceptSublist(int start, int end){
		return cloneExceptSublist(start,end, 0,first);
	}
	
	private LinkedList<E> cloneExceptSublist(int start, int end, int idx, Node<E> n){
		if(n == null)return new LinkedList<E>();
		LinkedList<E> ls = cloneExceptSublist(start,end, idx+1, n.next);
		if(idx < start || idx >=end)ls.addFirst(n.elem);
		return ls;
	}
	//função iterativa
	public LinkedList<E> cloneExceptSublistI(int start, int end){
		LinkedList<E> ls = new LinkedList<E>();
		int idx =-1;
		for(Node<E> n= first; n!=null; n=n.next){
			idx++;
			if(idx<start || idx>=end)ls.addLast(n.elem);
		}
		return ls;
	}
	
	//função recursiva	
	public void removeSublist(int start, int end){
		removeSublist(start, end, first, 0);
	}
	private void removeSublist(int start, int end, Node<E>n, int idx){
		if(idx<start-1)removeSublist(start, end, n.next, idx+1);
		if(idx == start-1 || start==0){
			Node<E> node = n;
			int numeros = end -start;
			do{
				node = node.next;
				numeros--;
			} while (numeros>=0);
			size = size -(end-start);
			if(node == null)last = n;
			if(start==0)first = node;
			n.next = node;
		}
	}
	//função iterativa
	public void removeSublistI(int start, int end){
		Node<E> n=first,node=first;
		for (int i = 0; i <end ; i++){
			if(i==start-1) n = node;
			if(i>=start && i <end)size--;
			node = node.next;
		}
		if(start==0) first = node;
		if(node == null) last = n;
		n.next = node;		
	}
}

