package visitor.file_system_handling;

class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // not optimal decision so do not uncomment
//        for (FileSystemElement element : directory.getElements()) {
//            element.accept(this); // visitor must manually recurse into sub-elements
//        }
    }

    public int getTotalSize() {
        return totalSize;
    }
}
