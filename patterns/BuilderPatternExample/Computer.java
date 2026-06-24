package BuilderPatternExample;

// Product class using Builder Pattern
public class Computer {
    // Attributes (final for immutability)
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final String powerSupply;

    // Private constructor accepts Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getPowerSupply() { return powerSupply; }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String powerSupply;

        public Builder CPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder RAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        // Final step: build the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}
