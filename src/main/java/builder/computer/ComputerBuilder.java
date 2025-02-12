package builder.computer;

import java.util.List;

interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    void addAccessories(List<Accessory> accessories);
    Computer getComputer();
}

