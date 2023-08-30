import java.util.ArrayList;
import java.util.List;

class LoadBalancer {
    private List<Server> servers;
    private int currentIndex;

    public LoadBalancer() {
        servers = new ArrayList<>();
        currentIndex = 0;

        // Add servers with initial weights
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 4));
        servers.add(new Server("Server3", 7));
    }

    public Server getNextServer() {
        int totalWeight = servers.stream().mapToInt(server -> server.weight).sum();

        Server selectedServer = null;
        int currentWeight = 0;
        synchronized (this) {
            for (Server server : servers) {
                currentWeight += server.weight;
                if (currentWeight >= currentIndex) {
                    selectedServer = server;
                    currentIndex = (currentIndex + 1) % totalWeight;
                    break;
                }
            }
        }

        return selectedServer;
    }

    public void adjustServerWeights() {
        // Simulate dynamic adjustment of server weights based on certain conditions
        for (Server server : servers) {
            int newWeight = server.weight + (int) (Math.random() * 3) - 1; // Random adjustment [-1, 1]
            newWeight = Math.max(newWeight, 1); // Ensure weight is not negative
            server.adjustWeight(newWeight);
        }
    }
}