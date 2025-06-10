package xyz;
abstract class Car{
	abstract void start();
	abstract void drive();
	abstract void stop();
	
	void music() {
		System.out.println("Playing Music");
	}
}

class key extends Car{
	
	void start() {
		System.out.println("Start the engine by start button");
	}
	void drive() {
		System.out.println("drive the car");
	}
	void stop() {
		System.out.println("Stop the car");
	}
}

public class AbstractTask {
	public static void main(String[] args) {
		
		key e = new key();
		e.start();
		e.drive();
		e.music();
		e.stop();
	}
	
}
 