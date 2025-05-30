package dsa;
interface printable{
	void print();
}
class Message implements printable{
	public void print() {
		System.out.println("Hello from interface");
	}
}
public class InterfaceExample {

	public static void main(String[] args) {
		Message msg = new Message();
		msg.print();

	}

}
