package bytes.io.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileStream {

//    public static final String FILE_NAME = "12345.txt";
    public static final String FILE_NAME = "C:\\Users\\krylo\\Pictures\\перерыв.png";

    public static void main(String[] args) {
        byte[] bw = {10, 20, 30};
        byte[] br = new byte[20];

        FileOutputStream out = null;
        FileInputStream in = null;

        byte[] bytes = readImages(br, in);

        modifyImages(bytes);
        writeImages(bytes, out);

//        writeData(bw, out);
//        readData(br, in);

    }

    private static void writeImages(byte[] bw, FileOutputStream out) {
        try {
            out = new FileOutputStream(FILE_NAME.replace(".png", "-new.png"));
            out.write(bw);
        } catch (IOException e) {
            e.getStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void modifyImages(byte[] bytes) {
        Random rand = new Random();
        for (int i = 100; i < 500; i++) {
            bytes[i] = (byte) (rand.nextInt(255) - 127);
        }
    }

    private static byte[] readImages(byte[] br, FileInputStream in) {
        try {
            in = new FileInputStream(FILE_NAME);
            byte[] bytes = in.readAllBytes();

            System.out.println("Прочитано " + bytes.length + "байт");
            for (byte b : bytes) {
                System.out.print(b + " ");
            }
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void readData(byte[] br, FileInputStream in) {
        try {
            in = new FileInputStream(FILE_NAME);
            int count = in.read(br);
            System.out.println("Прочитано " + count + "байт");
            for (byte b : br) {
                System.out.print(b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeData(byte[] bw, FileOutputStream out) {
        writeImages(bw, out);
    }
}
