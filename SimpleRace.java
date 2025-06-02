package dsa;

class Car extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("BMW car moving " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // Handle exception
            }
        }
    }
}

class Bike extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Ninja bike moving " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // Handle exception
            }
        }
    }
}

public class SimpleRace {
    public static void main(String[] args) {
        new Car().start();
        new Bike().start();
    }
}
