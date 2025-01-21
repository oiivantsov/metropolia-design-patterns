package composite.organization_structure;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {
        Organization company = new Organization("Design Patterns Ltd.");

        Employee ceo = new Employee("CEO", 5000);

        Department ITDepartment = new Department("IT Department");
        Employee itManager = new Employee("IT Manager", 3000);

        ITDepartment.add(itManager);

        Department DevOps = new Department("DevOps");
        Employee devOpsManager = new Employee("DevOps Manager", 2000);
        Employee devOpsEngineer1 = new Employee("DevOps Engineer 1", 1000);
        Employee devOpsEngineer2 = new Employee("DevOps Engineer 2", 1000);

        DevOps.add(devOpsManager);
        DevOps.add(devOpsEngineer1);
        DevOps.add(devOpsEngineer2);

        Department SystemAdmin = new Department("System Admin");
        Employee systemAdminManager = new Employee("System Admin Manager", 2000);
        Employee systemAdmin1 = new Employee("System Admin 1", 1000);
        Employee systemAdmin2 = new Employee("System Admin 2", 1000);

        SystemAdmin.add(systemAdminManager);
        SystemAdmin.add(systemAdmin1);
        SystemAdmin.add(systemAdmin2);

        ITDepartment.add(DevOps);
        ITDepartment.add(SystemAdmin);

        Department HRDepartment = new Department("HR Department");
        Employee hrManager = new Employee("HR Manager", 3000);
        Employee hrAssistant = new Employee("HR Assistant", 1000);

        HRDepartment.add(hrManager);
        HRDepartment.add(hrAssistant);

        company.add(ceo);
        company.add(ITDepartment);
        company.add(HRDepartment);

        System.out.println("Salary of the organization: " + company.getSalary());
        System.out.println("Organization structure in XML format:");

        // Format XML output
        String xml = formatXML(company.toXML());
        System.out.println(xml);

    }

    // Just a helper method to format XML output
    public static String formatXML(String input) {
        try {
            // Create a transformer for formatting the XML
            TransformerFactory factory = TransformerFactory.newInstance();
            factory.setAttribute("indent-number", 4); // Set indentation level
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

            // Perform the transformation
            StreamSource source = new StreamSource(new StringReader(input));
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);

            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return input; // Return unformatted input if an error occurs
        }
    }
}
