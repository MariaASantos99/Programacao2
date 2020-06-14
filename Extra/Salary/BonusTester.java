public class BonusTester {
	
	public static void main (String[] args) {
		Salary sal = new Salary(45000);
		sal.applyBonus(0.02); // 2% bonus
		System.out.println(sal.getValue());
		System.out.println("Expected: 45900.0");//test success
	}
	
	public static void  applyBonus(double value,double bonus){
		value = value * (1+bonus);
	}
}

