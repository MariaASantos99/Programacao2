import static java.lang.System.*;
import java.util.Calendar;

public class Data {
  private int dia, mes, ano;

  /** Inicia esta data com o dia de hoje. */
  public Data() {
    // Aqui usamos a classe Calendar da biblioteca standard para obter a data atual.
    Calendar today = Calendar.getInstance();
    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
  }

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }
  // Crie métodos para obter o dia, mes e ano da data.
  //...
  public int dia(){
    return dia;
  }
  public int mes(){
    return mes;
  }
  
  public int ano(){
    return ano;
  }
  

  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
    return diasMesComum[mes-1];
  }
  private static final String[] mesPorExtenso = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho",
    "Agosto","Setembro","Outubro","Novembro","Dezembro"};
  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
    return mesPorExtenso[mes-1];
  }

  /** Devolve esta data por extenso. */
  public String extenso() {
    return String.format("%d de %s de %d",dia, mesExtenso(),ano);
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
    boolean valor = true;
    if(mes<1 || mes >12){ 
      valor=false;
    }else if(ano<1){ 
      valor=false;
    }else if(mes==2){
      if(bissexto(ano)){
        if(dia<1 || dia>diasMesComum[mes-1]+1){
          valor = false;
        }
      }else{
        if(dia<1 || dia>diasMesComum[mes-1]){
          valor = false;
        }
      }
    }else{
      if(dia<1 || dia>diasMesComum[mes-1]){
        valor = false;
      }
    }
    return valor;
  }

  public void seguinte() {
    if(mes==2){
      if(bissexto(ano)){
        if(dia == diasMesComum[mes-1]+1){
          dia=1;
          mes+=1;
        }else dia+=1;
      }else{
        if(dia == diasMesComum[mes-1]){
          dia=1;
          mes+=1;
        }else dia+=1;
      }
    }else if(mes==12 && dia==diasMesComum[mes-1]){
      dia=1;
      mes=1;
      ano+=1;
    }else{
      if(dia == diasMesComum[mes-1]){
          dia=1;
          mes+=1;
      }else dia+=1;
    }
  }


}

