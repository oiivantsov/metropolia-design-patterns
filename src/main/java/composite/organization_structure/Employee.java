package composite.organization_structure;

public class Employee extends OrganizationUnit
{
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXML() {
        return "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />";
    }
}

