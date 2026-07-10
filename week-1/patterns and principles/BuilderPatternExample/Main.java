package BuilderPatternExample;

public class Main {
    public static void main(String[] args) {
        // Gaming Computer configuration
        Computer gamingPC = new Computer.Builder()
                                .CPU("Intel i9")
                                .RAM("32GB")
                                .storage("1TB SSD")
                                .graphicsCard("NVIDIA RTX 4090")
                                .powerSupply("850W")
                                .build();

        Computer officePC = new Computer.Builder()
                                .CPU("Intel i5")
                                .RAM("16GB")
                                .storage("512GB SSD")
                                .build(); // no graphics card or custom PSU

        System.out.println("Gaming PC: " + gamingPC.getCPU() + ", " + gamingPC.getRAM() + ", " +
                           gamingPC.getStorage() + ", " + gamingPC.getGraphicsCard() + ", " +
                           gamingPC.getPowerSupply());

        System.out.println("Office PC: " + officePC.getCPU() + ", " + officePC.getRAM() + ", " +
                           officePC.getStorage());
    }
}

