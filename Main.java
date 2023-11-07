import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        System.out.println("pwd===========================================");
        // FileSystem fs = FileSystems.getDefault();
        printCurrentDirectory();
        System.out.println("ls=========================================");

        File originalFile = new File("D:\\Домашні роботи\\Java\\Console\\a.txt");
        //File originalFile = new File(System.getProperty("user.dir"));
        printCurFolders(originalFile);




        System.out.println("cd==root=====================================");

        // Приклад зміни директорії на "C:\ExampleDirectory"
        changeDirectory("D:\\Домашні роботи\\Java");
        //printCurrentDirectory();

        System.out.println("Final===========================================");



    }

        public static void changeDirectory(String newDirectoryPath) {
            File newDirectory = new File(newDirectoryPath);

            if (newDirectory.isDirectory() && newDirectory.exists()) {
                System.setProperty("user.dir", newDirectory.getAbsolutePath());
                System.out.println("Директорія змінена на: " + newDirectory.getAbsolutePath());
            } else {
                System.out.println("Помилка: Директорія не існує.");
            }
        }





   public static void printCurFolders(File originalFile) {
     //  File originalFile = new File("C:\\Users\\Dell\\IdeaProjects\\J2\\a.txt");
        File folder = originalFile.getParentFile();
        for (File file : folder.listFiles())
        {
            if (file.isDirectory()) {
                System.out.println("-> " + file.getAbsolutePath());
            } else {
                System.out.println(file.getAbsolutePath() +
                        " (size in bytes: " + file.length() +
                        ", last modified: " + file.lastModified() + " )");
            }
        }
    }

    public static void printCurrentDirectory() {
        File currentDirectory = new File(System.getProperty("user.dir"));
        System.out.println("Поточна директорія: " + currentDirectory.getAbsolutePath());
    }
}