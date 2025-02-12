package builder.computer;

import java.util.List;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10");
    }

    @Override
    public void addAccessories(List<Accessory> accessories) {
        for (Accessory accessory : accessories) {
            computer.addAccessory(accessory);
        }
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}