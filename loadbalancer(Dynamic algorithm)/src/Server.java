class Server {
    String name;
    int weight;

    public Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public double estimateEnergyConsumption() {
        return weight * 10.0;
    }

    public void adjustWeight(int newWeight) {
        this.weight = newWeight;
    }
}