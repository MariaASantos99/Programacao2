package number;

/**
 * Tipo de dados representando uma fracção.
 * Nesta versão pretende-se garantir um invariante (interno) mais forte:
 * as frações armazenadas devem ter sempre denominador positivo.
 * Isto permite simplificar alguns métodos.
 *
 * AVISO: Vários métodos podem dar erros devidos a overflow.
 * (Não deve haver problemas com numeradores e denominadores até 46430.)
 *
 * @author João Manuel Rodrigues
 * 2007--2018
 */

public class Fraction
{
  private int num;
  private int den;

  /** Cria uma nova fracção a partir de um par (numerador, denominador).
   *  @param num numerador da nova fracção.
   *  @param den denominador da nova fracção.
   *  <b>Exige (pré-condição):</b> den != 0.
   */
  public Fraction(int num, int den) {
    assert (den != 0); // check precondition
    if(den<0){
		this.den = -den;
		this.num = -num;
	}else{
		this.den = den;
		this.num = num;
	} 
    assert invariant(); // check object invariant
  }

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fração.
   * É para testar em asserções nos métodos.
   */
  public boolean invariant() {
    return den > 0;   // O denominador não pode ser nulo!
  }

  /** Converte uma string numa fracção.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fracção válida.
   *  @return fracção correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) {
    String[] p = str.split("/", 2);  // divide a string em até 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length==2)? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, senão fica d=1
    if (d == 0) return null;
    return new Fraction(n, d);
  }

  /** Converte a fracção numa string.
   *  @return string com a representação desta fracção.
   */
  public String toString() {
    // Com um invariante mais forte, podemos simplificar este método!
    return num + "/" + den;
  }

  /** Devolve o numerador da fracção.
   *  @return numerador desta fração.
   */
  public int num() { return num; }

  /** Devolve o denominador da fracção.
   *  @return denominador desta fração.
   */
  public int den() { return den; }

  /** Multiplica esta fracção por outra (this * b).
   *  @param b multiplicando.
   *  @return fracção produto de this * b.
   */
	public Fraction multiply(Fraction b) {
		int n = num*b.num;
		int d = den*b.den;
		Fraction p = new Fraction(n, d); // product
		return p;
	}

  /** Adiciona esta fracção com outra (this + b).
   *  @param b fracção a adicionar a esta.
   *  @return fracção soma de this + b.
   */
	public Fraction add(Fraction b) {
		int n = num*b.den + den*b.num;
		int d = den*b.den;
		Fraction s = new Fraction(n, d); // sum
		return s;
	}

	public Fraction divide(Fraction b) {
		assert b.num/b.den >0;
		int n = num*b.den;
		int d = den*b.num;
		Fraction div = new Fraction(n,d);
		assert(b.multiply(div))==this;
		return div;
	}

	public Fraction subtract(Fraction b) {
		int n = num*b.den - den*b.num;
		int d = den*b.den;
		Fraction sub = new Fraction(n,d);
		assert ((b.add(sub))==this) && d>0;
		return sub;
	}

	public boolean equals(Fraction b) {
		double res1 = (double)this.num /(double) this.den;
		double res2 = (double)b.num / (double)b.den;
		if(res1 == res2)return true;
		return false;
	}

  //~ public int compareTo(Fraction b) {
    //~ //...
  //~ }

}
