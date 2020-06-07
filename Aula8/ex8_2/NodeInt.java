public class NodeInt{
	public final int elem;
	public NodeInt next;
	
	public NodeInt(int e, NodeInt n){
		elem = e;
		next = n;
	}
	
	public NodeInt(int e){
		elem = e;
		next = null;
	}
}

