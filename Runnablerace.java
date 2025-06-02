package dsa;

class Scooty implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("BMW Scooty moving " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // Handle exception
            }
        }
    }
}

class Lorry implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Ninja Lorry moving " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // Handle exception
            }
        }
    }
}
	
public class Runnablerace {
	public static void main(String[] args) {
		Thread caThread = new Thread(new Scooty());
		Thread baThread = new Thread(new Lorry());
		System.out.println("Goooo");
		caThread.start();
		baThread.start();

	}

}
