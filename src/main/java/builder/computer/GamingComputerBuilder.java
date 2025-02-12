package builder.computer;

import java.util.List;

class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB NVMe SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4080");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
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