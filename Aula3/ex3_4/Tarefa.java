public class Tarefa{
    private Data inicio;
    private Data fim;
    private String texto;
    
    public Tarefa(Data i, Data f, String t){
        this.inicio=i;
        this.fim=f;
        this.texto=t;
    }
    
    public Data inicio(){
        return this.inicio;
    }
    
    public Data fim(){
        return this.fim;
    }
    
    public String texto(){
        return this.texto;
    }
    
    public String toString(){
        return String.format("%s --- %s: %s", inicio.toString(), fim.toString(), texto);
    }
    
    public boolean intersecta (Data d1, Data d2){
		boolean r = false;
		if(inicio.compareTo(d1)==0 || inicio.compareTo(d2)==0){r=true;}
		else if(inicio.compareTo(d1)==1 && inicio.compareTo(d2)==-1){r=true;}
		else if(fim.compareTo(d1)==0 || fim.compareTo(d2)==0){r=true;}
		else if(fim.compareTo(d1)==1 && fim.compareTo(d2)==-1){r=true;}
		return r;
	}
}
