import java.io.*;
import java.time.LocalDate;
import java.util.*;

class Task implements Serializable {
    String name;
    String desc;
    LocalDate date;
    int prio;

    Task(String name, String desc, LocalDate date, int prio) {
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.prio = prio;
    }

    @Override
    public String toString() {
        return name + " | " + date + " | Priority: " + prio;
    }
}

class TaskManager {
    List<Task> tasks = new ArrayList<>();

    void add(Task t) {
        tasks.add(t);
    }

    void list() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (Task t : tasks) System.out.println(t);
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task | 2. Show Tasks | 3. Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Desc: ");
                String desc = sc.nextLine();
                System.out.print("Due Date (YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(sc.nextLine());
                System.out.print("Priority (1-5): ");
                int prio = sc.nextInt();

                tm.add(new Task(name, desc, date, prio));
            } else if (ch == 2) {
                tm.list();
            } else {
                break;
            }
        }
        sc.close();
    }
}
