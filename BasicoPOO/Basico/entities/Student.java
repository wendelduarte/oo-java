package entities;

public class Student {

	public String name;
	public double n1;
	public double n2;
	public double n3;
	
	public double calcGrade() {
		return n1 + n2 + n3;
	}
	
	public String verifyGrade() {
		double total = calcGrade();
		if (total > 60) {
			return "PASS";
		}else {
			return "FAILED\nMISSING " + (60-total) +" POINTS";
		}
	}
}
