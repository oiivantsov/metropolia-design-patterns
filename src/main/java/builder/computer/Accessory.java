package builder.computer;

class Accessory {
    private String name;

    public Accessory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}