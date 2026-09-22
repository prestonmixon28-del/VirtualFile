package VirtualFileSystemAnalyzer;

public class FileSystemAnalyzer {

    public static int countFilesRecursive(FileSystemItem item) {
        if (item instanceof FileItem) {
            return 1;
        }

        Folder folder = (Folder) item;
        int count = 0;

        for (FileSystemItem child : folder.getItems()) {
            count += countFilesRecursive(child);
        }

        return count;
    }

    public static int calculateTotalSizeRecursive(FileSystemItem item) {
        if (item instanceof FileItem) {
            return item.getSizeKB();
        }

        Folder folder = (Folder) item;
        int total = 0;

        for (FileSystemItem child : folder.getItems()) {
            total += calculateTotalSizeRecursive(child);
        }

        return total;
    }

    public static FileItem findLargestFileRecursive(FileSystemItem item) {
        if (item instanceof FileItem) {
            return (FileItem) item;
        }

        Folder folder = (Folder) item;
        FileItem largest = null;

        for (FileSystemItem child : folder.getItems()) {
            FileItem result = findLargestFileRecursive(child);

            if (result != null && (largest == null ||
                    result.getSizeKB() > largest.getSizeKB())) {
                largest = result;
            }
        }

        return largest;
    }
}


