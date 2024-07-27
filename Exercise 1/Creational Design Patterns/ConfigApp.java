
// Usage
public class ConfigApp {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println(config.getProperty("app.name"));
    }
}
