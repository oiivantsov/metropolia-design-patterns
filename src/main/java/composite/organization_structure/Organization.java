package composite.organization_structure;

import java.util.ArrayList;
import java.util.List;

// Actually Organization and Department here are the same, but in real world they are different, that's why we have two classes
// So, flexibility is the main reason
public class Organization extends OrganizationUnit {
    private List<OrganizationUnit> components = new ArrayList<>();

    public Organization(String name) {
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
        StringBuilder xml = new StringBuilder("<Organization name=\"" + name + "\">");
        for (OrganizationUnit component : components) {
            xml.append(component.toXML());
        }
        xml.append("</Organization>");
        return xml.toString();
    }
}
