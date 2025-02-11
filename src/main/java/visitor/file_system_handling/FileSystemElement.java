package visitor.file_system_handling;

interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}