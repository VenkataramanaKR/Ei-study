// Task Conflict in Observer

public class TaskConflictObserver implements Observer {
    private ScheduleManager scheduleManager;

    public TaskConflictObserver(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    @Override
    public void update(Task task) {
        // Logic to check for conflicts and notify user
        for (Task t : scheduleManager.getTasks()) {
            if (task.conflictsWith(t)) {
                System.out.println("Conflict detected: " + task.getDescription() + " conflicts with " + t.getDescription());
            }
        }
    }
}