package VirtualFileSystemAnalyzer;

public class FileItem  implements FileSystemItem {
    private String name;
    private int sizeKB;

    public FileItem (String name, int sizeKB) {
        this.name = name;
        this.sizeKB = sizeKB;
    }

    @Override 
    public String getName() {
        return name;
    }

    @Override 
    public int getSizeKB() {
        return sizeKB;
    }
    
}
