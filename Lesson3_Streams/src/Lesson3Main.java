import java.io.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.Scanner;

public class Lesson3Main {

    public static void main(String[] args) throws IOException {
        File dir = new File("/test1/test2/test3");
        dir.mkdirs();

        File file = new File("newFile.txt");
        System.out.println("can write: " + file.canWrite());
        System.out.println("fileName: " + file.getAbsolutePath());
        System.out.println("getParent: " + file.getAbsoluteFile().getParent());//???


        Scanner sc = new Scanner(System.in);
        sc.close();

        DataInputStream ds = new DataInputStream(new BufferedInputStream(new FileInputStream("out.txt")));

        System.out.println("isDir: " + file.isDirectory());
        System.out.println("lastModified: " + new Date(file.lastModified()));

        File rootDir = new File("c:\\Users\\krylo\\Google Диск\\My Library\\");
        displayDirectory("", rootDir);


    }

    private static void displayDirectory(String prefix, File rootDir) {
        for (File currentFile : rootDir.listFiles()) {
            if ( currentFile.isFile() ) {
                System.out.println(prefix + "FILE: " + currentFile.getName());
            }
            if ( currentFile.isDirectory() ) {
                System.out.println(prefix + "DIR: " + currentFile.getName());
                displayDirectory(prefix + "     ", currentFile);
            }
        }
    }
}
