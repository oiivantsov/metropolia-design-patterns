package visitor.file_system_handling;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory pictures = new Directory("pictures");

        File file1 = new File("resume.pdf", 2);
        File file2 = new File("photo.jpg", 5);
        File file3 = new File("notes.txt", 1);

        documents.addElement(file1);
        documents.addElement(file3);
        pictures.addElement(file2);
        root.addElement(documents);
        root.addElement(pictures);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size of all files: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Files matching search pattern:");
        for (File file : searchVisitor.getMatchedFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}