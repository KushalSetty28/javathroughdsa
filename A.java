package dsa;
abstract class Machine{
	abstract void ATM();
public void ATM2() {
	System.out.println("ATM USING JAVA WITH PHP");
	
}
}
class Bank extends Machine{
	void ATM() {
		System.out.println("ATM MACHINE USING JAVA");
	}
}
public class A {

	public static void main(String[] args) {
		Bank b = new Bank();
		b.ATM();
		b.ATM2();

	}

}
