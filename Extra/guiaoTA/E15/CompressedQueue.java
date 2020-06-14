/**
 * Complete este módulo de forma a que o programa principal funcione
 * devidamente.
 * 
 * Uma CompressedQueue é uma fila, mas onde valores consecutivos iguais
 * são "comprimidos" num único elemento da fila contendo o valor
 * e o número de repetições.
 * 
 * Além disto e dos métodos usuais, tem também métodos adicionais:
 * 
 * peekCount()
 *   Devolve o número de repetições do valor existente na frente da fila.
 * 
 * maxDiff()
 *   Indica qual o maior "salto" (em valor absoluto) entre elementos
 *   consecutivos da fila.
 * 
 * minDiff()
 *   Indica qual o menor "salto" (em valor absoluto) entre elementos
 *   consecutivos da fila.
 * 
 * toString()
 *   Devolve uma string com os elementos da fila (entre {}), por ordem, em que
 *   cada elemento é descrito pelo par valor e repetições (entre []) e 
 *   os elementos são separados por vírgulas.
 * 
 **/

public class CompressedQueue {
	private CompressedQueueNode first;
	private CompressedQueueNode last;
	int size;
	
	public CompressedQueue(){
		first = last = null;
		size = 0;
	}
	
	public int size() {return size;}
	
	public boolean empty() {return size==0;}
	
	public void in(int num){
		in(num, first);
	}
	
	private void in(int num , CompressedQueueNode n){
		if(empty()){			
			CompressedQueueNode node = new CompressedQueueNode(num, 1);
			node.next = null;
			first = node;
			last = node;
			size++;
		}else{
			if(n != null){
				if(n.elem == num) n.count++;
				else in(num, n.next);
			}else{
				CompressedQueueNode node = new CompressedQueueNode(num, 1);
				last.next = node;
				last = node;
				node.next = null;
				size++;
			}
		}
	}
	public int peek() {return first.elem;}
	
	public int peekCount() {return first.count;}
	
	public void out(){
		assert !empty() : "fila vazia";
		first = first.next;
		size--;
	}
	
	public String toString(){
		String s = "{";
		for (CompressedQueueNode n = first; n != null; n = n.next){
			if(!n.equals(first)) s+=",";
			s += "[" + n.elem + ":" + n.count + "]";
		}
		return s+"}";
	}
	
	public int maxDiff(){
		assert !empty() : "fila vazia";
		int max = 0;
		for (CompressedQueueNode n = first; n != last; n = n.next){
			int dif = n.elem - n.next.elem;
			if(Math.abs(dif)>max)max = Math.abs(dif);
		}
		return max;
	}
	
	public int minDiff(){
		assert !empty() : "fila vazia";
		int min = Integer.MAX_VALUE;
		for (CompressedQueueNode n = first; n != last; n = n.next){
			int dif = n.elem - n.next.elem;
			if(Math.abs(dif)<min)min = Math.abs(dif);
		}
		return min;
	}
	
	public void clear(){
		first = last = null;
		size=0;
	}	
	
}
//class node for compressedQueue
class CompressedQueueNode{
	int elem;
	int count;
	CompressedQueueNode next;
	public CompressedQueueNode(int elem, int count){
		this.elem = elem;
		this.count = count;
		next = null;
	}
}

