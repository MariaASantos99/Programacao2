package p2utils;

public class SortedKeyValueList<E>{
	private KeyValueNode<E> first = null;
	private int size=0;
	
	public SortedKeyValueList() {}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size ==0;}
	
	public boolean set(String k, E e) {
		int prev_size = size;
		first = set(first, k, e);
		assert contains(k) && get(k).equals(e);
		return size>prev_size;
	}
	private KeyValueNode<E> set(KeyValueNode<E> n, String k, E e) {
		if (n==null) {
			n = new KeyValueNode<E>(k, e);
			size++;
		}else if(n.key.compareTo(k)>0){
			KeyValueNode<E> node = n;
			n = new KeyValueNode<E>(k,e);
			n.next = node;
			size++;
		}else if (n.key.equals(k)) {
			n.elem = e;
		}else n.next = set(n.next, k, e);
		return n;
	}
	
	public E get(String k) {
		assert contains(k) : "Key does not exist";
		return get(first, k);
	}
	private E get(KeyValueNode<E> n, String k) {
		if (n.key.equals(k)) return n.elem;
		return get(n.next, k);
	}
	
	public void remove(String k) {
		assert contains(k) : "Key does not exist";
		first = remove(first, k);
		size--;
		assert !contains(k) : "Key still exists";
	}
	private KeyValueNode<E> remove(KeyValueNode<E> n, String k) {
		if (n.key.equals(k)) return n.next;
		n.next = remove(n.next, k);
		return n;
	}
	
	public boolean contains(String k) { 
		return contains(first, k);
	}
	private boolean contains(KeyValueNode<E> n, String k) {
		if (n == null || n.key.compareTo(k)>0) return false;
		if(n.key.compareTo(k)==0)return true; 
		return contains(n.next, k);
	}
	
	public void clear() {
		first = null;
		size = 0;
	}
	
	public String[] keys() {
		String[] keys = new String[size];
		keys(first, 0, keys);
		return keys;
	}
	private void keys(KeyValueNode<E> n, int i, String[] keys) {
		if (n==null) return;
		keys[i] = n.key;
		keys(n.next, i+1, keys);
		return;      
	}

	public String toString() {
		// Call a more versatile version with the proper delimiters and separator:
		return toString("{", ", ", "}");
	}
	
	public String toString(String left, String sep, String right) {
		String str = left;
		String[] keys = this.keys();
		int i;
		for(i = 0; i < keys.length-1; i++){
			str += "("+keys[i]+","+this.get(keys[i])+")"+sep;
		}
		str += "("+keys[i]+","+this.get(keys[i])+")";
		return str+right;
	}
}

