public class Agenda{
    private Tarefa task[] = new Tarefa[1000];
    private int size=0;
    
    public void novaTarefa(Tarefa t){
        if(size >task.length ){
            System.out.println("Agenda cheia!");
            System.exit(0);
        }
        int i=size;
        while(i>0 && t.inicio().compareTo(task[i-1].inicio())<0){
            task[i]=task[i-1];
            i--;
        }
        task[i]=t;
        size++;
    }
    
    public void escreve(){
        for (int i = 0; i < size; i++){
            System.out.println(task[i].toString());
        }
    }
    
    public Agenda filtra(Data d1, Data d2){
		Agenda a=new Agenda();
		for (int i = 0; i < size; i++) {

			if (task[i].intersecta(d1, d2)) {
			  a.task[a.size++] = task[i];
			}
		}
		return a;	
	}
}
