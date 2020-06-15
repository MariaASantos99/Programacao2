/**
Um objecto da classe Train representa um comboio composto de vários vagões
de mercadorias a granel.

Quando se cria um comboio, é necessário especificar a capacidade de cada
vagão e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vagão com certa carga à cauda de um comboio
(addWagon) ou pode retirar-se um vagão da cauda (removeWagon), segundo uma
política LIFO (último a entrar é o primeiro a sair).
Naturalmente, a carga de um vagão não pode superar a sua capacidade e só
se pode acrescentar um vagão que não faça ultrapassar a carga total máxima do
comboio.
Também é possível pedir para descarregar (unload) uma dada quantidade, o que
será feito pela descarga completa e retirada de zero ou mais vagões da cauda
e pela descarga parcial de outro vagão para completar a quantidade pedida.
Em qualquer altura é possível obter uma lista da carga nos vagões do
comboio (list); saber o número de vagões (size) ou a carga total
transportada (totalCargo).

Métodos principais:
addWagon     Acrescenta um vagão com uma certa carga ao fim do comboio.
removeWagon  Retira o vagão do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vagões que ficarem
             vazios.  Devolve o número de vagões retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vagão, do primeiro ao último.
             Não altera nada no comboio.
size         Tamanho (número de vagões) do comboio.
totalCargo   Carga total transportada no comboio.
**/

public class Train {
	private double capVag;
	private double capTotal;
	private int size;
	private double cargaTotal;
	private TrainNode first;
	private TrainNode last;
	
	public Train(double vc, double cc){
		this.capVag = vc;
		this.capTotal = cc;
		size = 0;
	}
	
	public boolean isEmpty() {return size==0;}
	
	public double totalCargo() {return cargaTotal;}
	
	public int size() {return size;}
	
	public double removeWagon(){
		assert !isEmpty() : "vazio!";
		double retira = first.elem;
		cargaTotal -= retira;
		first = first.next;
		size--;
		if(isEmpty()) last = null;
		return retira;
	}
	
	//~ if(size+carga > capTotal) return false;
	//~ else return true;
	public boolean acceptsCargo(double carga) {return cargaTotal+carga <= capTotal;}
	
	public void addWagon(double carga){
		TrainNode t = new TrainNode(carga);
		if(isEmpty()){
			first = t;
			last = t;
			t.next = null;
		}else{
			t.next = first;
			first = t;
		}
		size++;
		cargaTotal += carga;
	}
	
	public int unload(double carga){
		int c = 0;
		cargaTotal -= carga;
		for (TrainNode n = first; n != null && carga != 0 ; n = n.next){
			if(n.elem>carga){
				n.elem -= carga;
				carga = 0;
			}else{
				carga -= n.elem;
				first = first.next;//first = first.next;
				c++;
				size--;
			}	
		}		
		return c;
	}
	
	public double[] list(){
		double[] arr = new double[size];
		int i = size-1;
		for (TrainNode n = first; n != null; n= n.next){
			arr[i--] = n.elem;
		}
		return arr;
	}
}

class TrainNode{
	double elem;
	TrainNode next;
	public TrainNode(double e){
		this.elem = e;
		next = null;
	}
}
