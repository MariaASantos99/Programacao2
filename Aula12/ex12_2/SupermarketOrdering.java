import p2utils.*;

public class SupermarketOrdering {
	private Queue<Order> fila = new Queue<>();
	private HashTable<Integer> ht = new HashTable<>(10);
	
	public void enterOrder(Order order){
		fila.in(order);
		if(!ht.contains(order.prodName)) ht.set(order.prodName, order.quantity);
		else ht.set(order.prodName, ht.get(order.prodName)+order.quantity);
	}
	
	public Order serveOrder(){
		Order order = fila.peek();
		fila.out();
		if(ht.get(order.prodName)-order.quantity == 0) ht.remove(order.prodName);
		else ht.set(order.prodName, ht.get(order.prodName)-order.quantity);
		return order;
	}
	
	public int query(String product) {return ht.get(product);}
	
	public void displayOrders(){
		String[] keys = ht.keys();
		System.out.print("List of orders: " + fila.toString());
		System.out.print("\nSummary by product: ");
		for (int i = 0; i < keys.length; i++){
			System.out.printf("%s:%d ", keys[i], ht.get(keys[i]));
		}
		System.out.println();
	}
	
	public int numOrders() {return fila.size();}
}

