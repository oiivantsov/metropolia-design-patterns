package visitor.file_system_handling;

import java.util.ArrayList;
import java.util.List;

// finds files matching a specific name pattern or extension
class SearchVisitor implements FileSystemVisitor {
    private final String searchPattern;
    private final List<File> matchedFiles = new ArrayList<>();

    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchPattern)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // traversal logic in Directory class
    }

    public List<File> getMatchedFiles() {
        return matchedFiles;
    }
}