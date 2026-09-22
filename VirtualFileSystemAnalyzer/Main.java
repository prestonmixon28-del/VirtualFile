package VirtualFileSystemAnalyzer;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Folder root = new Folder("Root");

        Folder documents = new Folder("Documents");
        Folder pictures = new Folder("Pictures");
        Folder vacations = new Folder("Vacations");

        documents.addItem(new FileItem("resume.docx", 100));
        documents.addItem(new FileItem("notes.txt", 50));

        pictures.addItem(new FileItem("photo1.jpg", 200));

        

        pictures.addItem(vacations);

        root.addItem(documents);
        root.addItem(pictures);

        boolean running = true;

        while (running)
            System.out.println("\n1. Display File system");
        System.out.println("2 add file");
        System.out.println(" 3 add folder");
        System.out.println("4 recursive audit"); 
        System.out.println("5 iterative audit"); 
        System.out.println("6 exit"); 
        System.out.println("choose"); 
        
        String choices = scanner.nextLine();

        switch (choice) {

            case "1":
            printHierarchy(root, "");
            break;

            case "2":
                System.out.println(" file name ");
                String name = scanner.nextLine();

                System.out.println("size in kb ");
                int size;
                
                try {
                    size = Integer.parseInt(scanner.nextLine());

                    if (size < 0) {
                        System.out.println("size cannot be negative");
                        break; 
                    }

                    System.out.println("folder name ");
                    String folderName = scanner.nextLine();
                    
                    Folder folder = findFolder(root, folderName);

                    if (folder == null) {
                        System.out.println("folder not found"); 
                    } else {
                        folder.addItem(new FileItem(name, size));
                        System.out.println("file added"); 
                    }
                    break;

                    case "3":
                        System.out.println("new folder name ");
                        String newName = scanner.nextLine();
                        
                        System.out.println("parent folder ");
                        String parentName = scanner.nextLine();

                        Folder parent = findFolder(root, parentName);

                        if (parent == null) {
                            System.out.println("folder not found");
                        } else {
                            parent.addItem(new Folder(newName));
                            System.out.println("folder added ");
                        }
                        break;

                        case "4":
                            int count = FileSystemAnalyzer.countFilesRecursive(root);
                            int sizeTotal =
                            FileSystemAnalyzer.calculateTotalSizeRecursive(root);
                            FileItem largest =
                            FileSystemAnalyzer.findLargestFileRecursive(root);

                            System.out.println("files " + count);
                            System.out.println("Total size" + sizeTotal + " KB" );

                            if (largest == null) {
                                System.out.println("no files"); 
                            } else {
                                System.out.println("largest " + largest.getName() + " (" + largest.getSizeKB() + "KB)");
                            }
                            break;

                            case "5":
                                FileSystemAnalyzer.countFilesRecursive(root);

                    int iterative =

                            FileSystemAnalyzer.countFilesIterative(root);

                    System.out.println("Iterative files: " + iterative);

                    System.out.println("Counts match: "

                            + (recursive == iterative));

                    break;

                case "6":

                    running = false;

                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }

        }

        scanner.close();

    }

    public static Folder findFolder(Folder current, String targetName) {

        if (current.getName().equalsIgnoreCase(targetName)) {

            return current;

        }

        for (FileSystemItem item : current.getItems()) {

            if (item instanceof Folder) {

                Folder found = findFolder((Folder) item, targetName);

                if (found != null) {

                    return found;

                }

            }

        }

        return null;

    }

    public static void printHierarchy(FileSystemItem item, String indent) {

        System.out.println(indent + item.getName());

        if (item instanceof Folder) {

            for (FileSystemItem child : ((Folder) item).getItems()) {

                printHierarchy(child, indent + "  ");

            }

        
                }
        
        {
            
        }
     }
}
