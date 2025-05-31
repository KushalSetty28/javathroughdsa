package dsa;
class Calculator{
	int cal(int a, int b) {
		return a+b;
	}
	double cal(double a, double b) {
		return a*b;
	}
	int cal(int a, int b, int c) {
		return a*b*c;
	}
}
public class OverloadingExample {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println(c.cal(3,6));
		System.out.println(c.cal(3.5, 4.9));
		System.out.println(c.cal(2,3,5));
		
	}

}
 // method overloading means having multiple methods with the same name for different parameters with same class