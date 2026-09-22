package VirtualFileSystemAnalyzer;

public class Main {
     public static void main(String[] args) {

        Folder root = new Folder("Root");

        Folder documents = new Folder("Documents");
        Folder pictures = new Folder("Pictures");
        Folder vacations = new Folder("Vacations");

        documents.addItem(new FileItem("resume.docx", 100));
        documents.addItem(new FileItem("notes.txt", 50));

        pictures.addItem(new FileItem("photo1.jpg", 200));

        vacations.addItem(new FileItem("beach.jpg", 300));
        vacations.addItem(new FileItem("hotel.jpg", 250));

        pictures.addItem(vacations);

        root.addItem(documents);
        root.addItem(pictures);

        int totalFiles = FileSystemAnalyzer.countFilesRecursive(root);
        int iterativeFiles = FileSystemAnalyzer.countFilesIterative(root);
int totalSize = FileSystemAnalyzer.calculateTotalSizeRecursive(root);
FileItem largestFile = FileSystemAnalyzer.findLargestFileRecursive(root);

System.out.println("Total number of files: " + totalFiles);
System.out.println("Total storage: " + totalSize + " KB");
System.out.println("Largest file: " + largestFile.getName());
System.out.println("Largest file size: " + largestFile.getSizeKB() + " KB");
System.out.println("Iterative file count: " + iterativeFiles);
    }
}
