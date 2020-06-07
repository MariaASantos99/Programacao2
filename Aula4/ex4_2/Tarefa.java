public class Tarefa{
    private Data inicio;
    private Data fim;
    private String texto;
    
    public Tarefa(Data i, Data f, String t){
		assert(t != "");
		assert(i.compareTo(f)==-1);
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
}
