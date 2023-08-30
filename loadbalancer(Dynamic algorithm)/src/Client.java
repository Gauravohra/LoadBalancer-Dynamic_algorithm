
public class Client {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();
        double totalEnergyConsumption = 0;

        // Simulate multiple requests and dynamic weight adjustments
        for (int i = 0; i < 40; i++) {
            // Adjust server weights dynamically
            loadBalancer.adjustServerWeights();

            Server server = loadBalancer.getNextServer();
            System.out.println("Request " + (i + 1) + " routed to: " + server.name);

            // Simulate server response time
            int responseTime = (int) (Math.random() * 300);

            if (isSLAAdhered(responseTime)) {
                System.out.println("SLA Adhered for Request " + (i + 1));
            } else {
                System.out.println("SLA Not Adhered for Request " + (i + 1));
            }

            totalEnergyConsumption += server.estimateEnergyConsumption();
        }

        System.out.println("Total Energy Consumption: " + totalEnergyConsumption);
    }

    public static boolean isSLAAdhered(int responseTime) {
        return responseTime <= 200;
    }
}



