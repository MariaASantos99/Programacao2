public class Salary {
	private double salario;
	public Salary(double sal){
		this.salario = sal;
	}
	
	public double applyBonus(double bonus){
		return this.salario += this.salario * bonus;
	}
	
	public double getValue(){
		return this.salario;
	}
}

