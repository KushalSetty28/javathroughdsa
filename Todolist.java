// package TODO_Package;

import java.util.*;
public class Todolist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> tasks = new ArrayList<>();
		
		while(true) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("|      Simple To-Do-List-App     |");
			System.out.println("|      1. Add a Task             |");
			System.out.println("|      2. View a Task            |");
			System.out.println("|      3. Delete a Task          |");
			System.out.println("|      4. Exit                   |");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("Choose an Option (1 - 4): ");
			System.out.print("Enter your choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {

			// 1. Add a Task
			case 1:
				System.out.println("Enter the task to be added: ");
				String task = sc.nextLine();
				tasks.add(task);
				System.out.println("Task added successfully!");
				break;

			// 2. View a Task
			case 2:
				if(tasks.isEmpty()) {
					System.out.println("No tasks found!");
				}else {
					System.out.println("Tasks: ");
					for(int i = 0; i < tasks.size(); i++) {
						System.out.println((i + 1) + ". " + tasks.get(i));
					}
				}
				break;
			
			// 3. Delete a Task
			case 3:
				if(tasks.isEmpty()) {
					System.out.println("No tasks found!");
				}else {
					System.out.println("Tasks: ");
					for(int i = 0; i < tasks.size(); i++) {
						System.out.println((i + 1) + ". " + tasks.get(i));
					}
					System.out.println("Enter the task number to be deleted: ");
					int taskNumber = sc.nextInt();
					if(taskNumber >= 1 && taskNumber <= tasks.size()) {
						tasks.remove(taskNumber - 1);
						System.out.println("Task deleted successfully!");
					}else {
						System.out.println("Invalid task number!");
					}
				}
				break;

			// 4. Exit
			case 4:
				System.out.println("Exiting the application...");
				System.exit(1);
				break;
			default:
				System.out.println("Invalid choice! Please choose a valid option.");
				break;
			}
			sc.close();
		}
		
	}
}