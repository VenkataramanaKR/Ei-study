import java.util.ArrayList;
import java.util.List;

//Main Program

public class ScheduleApp {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        scheduleManager.addObserver(new TaskConflictObserver(scheduleManager));

        Task task1 = TaskFactory.createTask("Morning Exercise", "07:00", "08:00", "High");
        scheduleManager.addTask(task1);

        Task task2 = TaskFactory.createTask("Team Meeting", "09:00", "10:00", "Medium");
        scheduleManager.addTask(task2);

        List<Task> tasks = scheduleManager.getTasks();
        for (Task task : tasks) {
            System.out.println(task.getStartTime() + " - " + task.getEndTime() + ": " + task.getDescription() + " [" + task.getPriority() + "]");
        }

        scheduleManager.removeTask(task1);

        Task task3 = TaskFactory.createTask("Lunch Break", "12:00", "13:00", "Low");
        scheduleManager.addTask(task3);

        // Check for task conflict
        Task conflictingTask = TaskFactory.createTask("Training Session", "09:00", "10:00", "High");
        scheduleManager.addTask(conflictingTask);

        // View all tasks
        tasks = scheduleManager.getTasks();
        for (Task task : tasks) {
            System.out.println(task.getStartTime() + " - " + task.getEndTime() + ": " + task.getDescription() + " [" + task.getPriority() + "]");
        }
    }
}
