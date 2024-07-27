import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Concrete observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Subject
class ChatRoom {
    private List<Observer> users = new ArrayList<>();

    public void addUser(Observer user) {
        users.add(user);
    }

    public void removeUser(Observer user) {
        users.remove(user);
    }

    public void sendMessage(String message) {
        for (Observer user : users) {
            user.update(message);
        }
    }
}

// Usage
public class ChatApp {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Venkat");
        User user2 = new User("Vishnu");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        chatRoom.sendMessage("Hello, everyone!");
    }
}
