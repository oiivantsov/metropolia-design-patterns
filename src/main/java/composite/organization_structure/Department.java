package composite.organization_structure;

import java.util.List;
import java.util.ArrayList;

public class Department extends OrganizationUnit {
    private List<OrganizationUnit> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationUnit component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationUnit component) {
        components.remove(component);
    }

    @Override
    public double getSalary() {
        double salary = 0;
        for (OrganizationUnit component : components) {
            salary += component.getSalary();
        }
        return salary;
    }

    @Override
    public String toXML() {
        StringBuilder xml = new StringBuilder("<Department name=\"" + name + "\">");
        for (OrganizationUnit component : components) {
            xml.append(component.toXML());
        }
        xml.append("</Department>");
        return xml.toString();
    }
}
