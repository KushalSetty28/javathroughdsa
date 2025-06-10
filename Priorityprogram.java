package xyz;

public class Priorityprogram {

	public static void main(String[] args) {
		Thread lowPriorityThread = new Thread(() ->{
		for(int i = 1;i<=5;i++) {
			System.out.println("Low Priority Thread "+i);
			}
		});
	Thread highPriorityThread = new Thread (() -> {
		for(int i= 1;i<=5;i++) {
			System.out.println("High Priority Thread"+i);
		}
	});
	
	lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
	highPriorityThread.setPriority(Thread.MAX_PRIORITY);
	
	lowPriorityThread.start();
	highPriorityThread.start();
	}
}
//it is like a line of kids waiting for ice cream but instead of going i order the kids wtih
//the highest priority goes first.