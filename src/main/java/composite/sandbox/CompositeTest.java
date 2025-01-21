package composite.sandbox;

public class CompositeTest {

    public static void main(String[] args) {
        Component hardDisk = new Leaf(4000, "Hard Disk");
        Component mouse = new Leaf(500, "Mouse");
        Component monitor = new Leaf(8000, "Monitor");
        Component ram = new Leaf(3000, "RAM");
        Component cpu = new Leaf(9000, "CPU");

        Composite ph = new Composite("Peripherals");
        Composite cabinet = new Composite("Cabinet");
        Composite mb = new Composite("Motherboard");
        Composite computer = new Composite("Computer");

        mb.addComponent(ram);
        mb.addComponent(cpu);

        ph.addComponent(mouse);
        ph.addComponent(monitor);
        cabinet.addComponent(hardDisk);
        cabinet.addComponent(mb);

        computer.addComponent(ph);
        computer.addComponent(cabinet);

        ram.showPrice();

    }
}
