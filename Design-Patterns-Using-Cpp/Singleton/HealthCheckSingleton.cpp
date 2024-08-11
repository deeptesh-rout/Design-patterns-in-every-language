import java.util.ArrayList;
import java.util.List;

public class HealthCheckSingleton {
    private static HealthCheckSingleton instance;
    private List<String> servers;

    private HealthCheckSingleton() {
        this.servers = new ArrayList<>();
    }

    public static HealthCheckSingleton getInstance() {
        if (instance == null) {
            instance = new HealthCheckSingleton();
        }
        return instance;
    }

    public void addServer() {
        this.servers.add("Server 1");
        this.servers.add("Server 2");
    }

    public void changeServer() {
        this.servers.remove(this.servers.size() - 1);
        this.servers.add("Server 5");
    }

    public List<String> getServers() {
        return this.servers;
    }

    public static void main(String[] args) {
        HealthCheckSingleton hc1 = HealthCheckSingleton.getInstance();
        hc1.addServer();

        HealthCheckSingleton hc2 = HealthCheckSingleton.getInstance();
        hc2.addServer();

        System.out.println(hc1.getServers());
        System.out.println(hc2.getServers());
    }
}

/*
[Server 1, Server 2, Server 1, Server 2]
[Server 1, Server 2, Server 1, Server 2]
 */