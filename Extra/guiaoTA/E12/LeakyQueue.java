/**
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos.
 * Quando a fila está preenchida (N elementos) a inserção de um novo número
 * implica a saída do primeiro (que deixa de existir).
 */

public class LeakyQueue{
	double[] nums;
	int size = 0;
	double min = Double.MAX_VALUE;
	
	public LeakyQueue(int N) {
		assert N>0;
		nums = new double[N];
	}
	
	public boolean isEmpty() {return size == 0;}
	
	public boolean isFull() {return size == nums.length;}
	
	public int size() {return size;}
	
	public void print(){
		for (int i = size-1; i>=0; i--){
			System.out.printf("%2.1f  ", nums[i]);
		}	
	}
	
	public void in(double n) {
		if(isFull()) {out();}
		else if(size >0) {System.arraycopy(nums, 0, nums, 1, size);}
		
			nums[0] =  n;
			size++;
	}
	
	public void out() {
		System.arraycopy(nums, 0, nums, 1, size-1);
		size--;
	}
	
	public double minimum() {
		min = nums[0];
		for (int i = 1; i <= size-1 ; i++){
			if(min > nums[i])min = nums[i];
		}
		return min;
	}
}

