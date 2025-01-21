package composite.organization_structure;

abstract class OrganizationUnit {
    protected String name;

    public OrganizationUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(OrganizationUnit component) {}

    public void remove(OrganizationUnit component) {}

    public abstract double getSalary();

    public abstract String toXML();
}
