import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) {
    Data atual = new Data();
    Data natal = new Data(25,12,atual.ano()-1);
    while((natal.ano() != atual.ano())||(natal.mes() != atual.mes())&&(natal.dia() != atual.dia())){
		out.println(natal.extenso());
		natal.seguinte();
	}
	
  }

}

