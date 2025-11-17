/**
 * This is a simple task scheduler program where the user 
 * can do multiple operations on tasks such as addition, deletion, 
 * search, update, and view all.
 * 
 * @author Elvin Ismayil (22501036)
 * @version 17.11.2025 15:48
 */

package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Q2 {

    // We initialize variables here
    static String[] taskNames;
    static int[] priorities;
    static int taskCount;
    static ArrayList<String> taskNamesList = new ArrayList<String>();
    static ArrayList<Integer> prioritiesList = new ArrayList<Integer>();
    static boolean switchedToList = false;
    static Scanner input = new Scanner(System.in);

    public static void addTask(String name, int priority) {
        // If the array is not full yet we continue adding tasks there 
        if (!switchedToList) {
            for (int i = 0; i < taskNames.length; i++) {
                if (taskNames[i] == null) {
                    taskNames[i] = name;
                    priorities[i] = priority;
                    System.out.println("Task added successfully!");
                    taskCount++;
                    return;
                }
            }
            // When the array is full we switch to arraylist and change the 
            // boolean switchedToList to true and then move all the tasks from the 
            // array to arraylist
            switchedToList = true;
            System.out.println("Array full! Switching to dynamic ArrayList...");
            for (int i = 0; i < taskNames.length; i++) {
                taskNamesList.add(taskNames[i]);
                prioritiesList.add(priorities[i]);
            }
        }
        // If we have switched to arrayList then we use methods for it here
        taskNamesList.add(name);
        prioritiesList.add(priority);
        System.out.println("Task added successfully!");
        taskCount++;
    }

    public static void removeTask(String name) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equals(name)) {
                taskNames[i] = null;
                priorities[i] = 0;
                taskCount--;
                System.out.println("Task removed successfully.");
                return;
            }
        }

        for (int i = 0; i < taskNamesList.size(); i++) {
            if (taskNamesList.get(i).equals(name)) {
                taskNamesList.remove(i);
                prioritiesList.remove(i);
                taskCount--;
                System.out.println("Task removed successfully.");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public static void updateTaskPriority(String name, int newPriority) {

    for (int i = 0; i < taskNames.length; i++) {
        if (taskNames[i] != null && taskNames[i].equals(name)) {

            int current = priorities[i];
            System.out.println("Current priority: " + current);

            while (newPriority == current) {
                System.out.println("New priority cannot be the same as the current priority. Try again.");
                System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                newPriority = input.nextInt();
            }

            priorities[i] = newPriority;
            System.out.println("Priority updated successfully!");
            return;
        }
    }

    for (int i = 0; i < taskNamesList.size(); i++) {
        if (taskNamesList.get(i).equals(name)) {

            int current = prioritiesList.get(i);
            System.out.println("Current priority: " + current);

            while (newPriority == current) {
                System.out.println("New priority cannot be the same as the current priority. Try again.");
                System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                newPriority = input.nextInt();
            }

            prioritiesList.set(i, newPriority);
            System.out.println("Priority updated successfully!");
            return;
        }
    }

    System.out.println("Task not found!");
}

    public static void searchTask(String name) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equals(name)) {
                System.out.println("Task found. " + "Priority: " + priorities[i]);
                return;
            }
        }

        for (int i = 0; i < taskNamesList.size(); i++) {
            if (taskNamesList.get(i).equals(name)) {
                System.out.println("Task found. " + "Priority: " + priorities[i]);
                return;
            }
        }

        System.out.println("Task not found!");
    }

    public static void viewAllTasks() {

        if (taskCount == 0) {
            System.out.println("No task to display.");

        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < taskNames.length; i++) {
                if (taskNames[i] != null) {
                    System.out.println(i + 1 + ". " + taskNames[i] + " (Priority " + priorities[i] + ")");
                }
            }

            for (int i = 0; i < taskNamesList.size(); i++) {
                if (taskNamesList.get(i) != null) {
                    System.out.println(i + 1 + ". " + taskNamesList.get(i) + " (Priority " + prioritiesList.get(i) + ")");
                }
            }
        }

    }

    public static void exit() {
        System.out.println("Quit!");
        System.exit(0);
    }

    public static void main(String[] args) {
        // We first ask the user to enter the capacity for defining intial arrays
        System.out.print("Enter initial task capacity: ");
        int taskCapacity = input.nextInt();
        taskNames = new String[taskCapacity];
        priorities = new int[taskCapacity];

        while (true) {
            System.out.println("=== Task Scheduler ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task Priority");
            System.out.println("4. Search Task");
            System.out.println("5. View All Tasks");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                System.out.print("Enter task name: ");
                String name = input.nextLine();
                System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                int priority = input.nextInt();
                addTask(name, priority);
            }

            if (option == 2) {
                System.out.print("Enter task name to remove: ");
                String taskName = input.nextLine();
                removeTask(taskName);
            }

            if (option == 3) {
                System.out.print("Enter task name to update: ");
                String taskName = input.nextLine();
                System.out.print("Enter priority (1=High, 2=Medium, 3=Low): ");
                int priority = input.nextInt();

                updateTaskPriority(taskName, priority);
            }

            if (option == 4) {
                System.out.print("Enter task name to search: ");
                String taskName = input.nextLine();
                searchTask(taskName);
            }

            if (option == 5) {
                viewAllTasks();
            }

            if (option == 6) {
                exit();
            }

        }
    }

}
