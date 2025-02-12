package builder.computer;

import java.util.ArrayList;
import java.util.List;

class Computer {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private List<Accessory> accessories = new ArrayList<>();

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "Processor: " + processor + "\n" +
                "RAM: " + ramSize + " GB\n" +
                "Hard Drive: " + hardDrive + "\n" +
                "Graphics Card: " + graphicsCard + "\n" +
                "Operating System: " + operatingSystem + "\n" +
                "Accessories: " + (accessories.isEmpty() ? "None" : accessories) + "\n";
    }
}
