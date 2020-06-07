import java.util.*; 
import java.lang.*; 
import java.io.*; 
public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private Data data;
	public Pessoa(Data d_nasc, String nome){
		data = d_nasc;
		this.nome = nome;
	}
	
	public String nome(){
		return this.nome;
	}
	
	public Data d_nasc(){
		return this.data;
	}
	
	public String toString(){
		return String.format("(%s, %s)", data.toString(), nome);
	}
	
	public int compareTo(Pessoa p2){
		int result = 0;
		if(this.data.mes()>p2.data.mes())result=1;
		else if(this.data.mes()<p2.data.mes())result=-1;
		else{
			if(this.data.dia()>p2.data.dia())result=1;
			else if(this.data.dia()<p2.data.dia())result=-1;
		}
		return result;
	}
}
