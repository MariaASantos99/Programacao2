//Maria Santos 87965
package p2utils;

public class SortedList<E extends Comparable<E>>{
  // private attributes
  private Node<E> first = null;
  private int size = 0;

  public SortedList() { }

  /**
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";
      return first.elem;
  }

  /** Inserts a new element in the list.
   * @param e the element to be inserted
   */
  public void insert(E e) {
    first = insert(first,e);
    size++;
  }
  private Node<E> insert(Node<E> n,E e) {
    if ((n==null) || (e.compareTo(n.elem)<0))
      return new Node<E>(e,n);
    n.next = insert(n.next,e);
    return n;
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
  }

  /** Checks if the list is sorted.
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    if (size < 2)
      return true;
    return isSorted(first,first.next); 
  }
  private boolean isSorted(Node<E> prev,Node<E> n) {
    if (n == null) return true;
    if (n.elem.compareTo(prev.elem) < 0) return false;
    return isSorted(n,n.next);
  }
  
	public boolean contains(E e){
		return contains(first,e);
	}
	  
	private boolean contains(Node<E> n, E e){
		if(n==null) return false;
		int valor = n.elem.compareTo(e);
		if(valor == 0) return true;
		if(valor > 0) return false;
		return contains(n.next,e);
	}

	public String toString(){
		String str = "[";
		String separador = "";
		for (Node<E> n = first; n != null; n=n.next){
			str += separador +n.elem ;
			separador = ", ";
		}
		return str +"]";
	}
  
	public SortedList<E> merge(SortedList<E> list2){
		SortedList<E> lst = new SortedList<>();
		lst.mergeR(null, this.first, list2.first);
		return lst;
	}
	
	private void mergeR(Node<E> last, Node<E> n1, Node<E> n2){
		assert last==null || last.next==null;
		if(n1==null && n2==null){
			return;
		}else if(n1==null){
			assert n2!=null;
			mergeR(last, n2, n1);
		}else if(n2==null || n1.elem.compareTo(n2.elem)<=0){
			assert n1!=null;
			Node<E> n = new Node<E>(n1.elem, null);
			if(last==null)first = n;
			else last.next = n;
			last = n;
			this.size++;
			mergeR(last,n1.next, n2);
		}else{//n2.elem < n1.elem
			mergeR(last, n2, n1);
		}
	}
}


