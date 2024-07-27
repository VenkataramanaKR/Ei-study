//Singleton

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }
}