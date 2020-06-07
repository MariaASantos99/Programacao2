package p2utils;
public class SortedArray<E extends Comparable<E>>{
	private int size;
	private E[] arr;
	
	public SortedArray(int size){
		arr = (E[])new Comparable[size];
		this.size = 0;
	}
	
	public int size(){ return size; }
	
	public boolean isEmpty(){ return size==0;}
	
	public boolean isFull(){
		if(arr.length == size)return true;
		else return false;
	}
	/**
	 * @return o primeiro elemento do array
	 */ 
	 public E first(){
		 assert !isEmpty() : "empty";
		 return arr[0];
	 }
	 
	 /**
	  * remove o primeiro elemento do array
	  */
	public void removeFirst(){
		assert !isEmpty() : "empty";
		arr[0]=null;
		for (int i = 1; i < size; i++){
			arr[i-1]=arr[i];
		}
		arr[size-1] = null;
		size--;
	}
	/**Insere um novo elemento ao array
	 * @param e o elemento a ser inserido
	 */
	public void insert(E e){
		int idx = insert(size,e);
		arr[idx] = e;
		size++;
	}
	
	private int insert(int tamanho, E e){
		int i=0;
		if(tamanho==0 || e.compareTo(arr[tamanho-1])>0)return tamanho;
		arr[tamanho] = arr[tamanho-1];
		i= insert(tamanho-1, e);
		return i;
	}
	
	public boolean isSorted(){
		if(size<2)return true;
		return isSorted(0,1);
	}
	private boolean isSorted(int prev,int n) {
		if (n==size) return true;
		if (arr[n].compareTo(arr[prev]) < 0) return false;
		return isSorted(n,n+1);
	}
	
	public boolean contains(E e){
		return contains(0,e);
	}
	
	private boolean contains(int start, E e){
		if(start == size)return false;
		int valor = arr[start].compareTo(e);
		if(valor == 0) return true;
		if(valor < 0)/**ou valor>0*/ return false;
		return contains(start+1,e);
	}
	
	/**
	 * Imprime o array
	 */
	public String toString(){
		String str = "[";
		String separador = "";
		for (int i = 0; i < size; i++){
			str += separador +arr[i];
			separador = ", ";
		}
		return str +"]";
	}
	public SortedArray<E> merge(SortedArray<E> that){
		SortedArray<E> merged = new SortedArray<E>(this.arr.length + that.arr.length);
		int i=0,j=0,k=0;
		while(i<this.size && j<that.size){
			if(this.arr[i].compareTo(that.arr[j])<=0)
				merged.arr[k++]=this.arr[i++];
			else 
				merged.arr[k++]=that.arr[j++];
		}
		//copiar os subarrays para o array merged
		System.arraycopy(this.arr, i, merged.arr, k, this.size-i);
		System.arraycopy(that.arr, j, merged.arr, k, that.size-j);
		merged.size = this.size+that.size;
		return merged;
	}
	
}

