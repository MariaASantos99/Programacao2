/**
 * Uma estrutura de dados de tipo pilha, mas com os métodos alternativos:
 * - popN(n): retira os n elementos de topo da pilha
 * - topMatches(seqChars): verifica se os últimos caracteres na pilha
 *                         coincidem com seqChars
 * - toString(): devolve uma String com todos os caracteres contidos
 *               na pilha (desde o mais antigo até ao mais recente)
 */

public class StackX{
	char[] pilha = new char[1];
	int size=0;
	
	public void push(char c){
		if(size == pilha.length){
			char[] newchar = new char[pilha.length+pilha.length];
			System.arraycopy(pilha, 0, newchar, 0, pilha.length);
			pilha = newchar;
		}		
		pilha[size++] = c;
	}
	
	public String toString(){
		String s="";
		for (int i = 0; i < pilha.length; i++){
			s += pilha[i];
		}		
		return s;
	}
	
	public void popN(int n){
		System.arraycopy(pilha, 0, pilha, 0, size-n);
		size -=n;
	}
	
	public boolean topMatches(String s){
		if(s.length() > size)return false;
		else{
			int j = size-1;
			for (int i = 0; i < s.length(); i++){
				if(s.charAt(i) != pilha[j--])return false;
			}
			return true;			
		}
	}
	
	public int size() {return size;}
	
	public char top() {return pilha[size-1];}	
}

