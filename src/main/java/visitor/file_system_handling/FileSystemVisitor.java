package visitor.file_system_handling;

interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}

