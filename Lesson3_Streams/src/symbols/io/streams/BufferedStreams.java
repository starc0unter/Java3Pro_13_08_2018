package symbols.io.streams;

import java.io.*;

public class BufferedStreams {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try{
            bw = new BufferedWriter(new FileWriter("input.txt"));
            for (int i=0; i < 20; i++) bw.write("Java");
            bw.close();
            br = new BufferedReader(new FileReader("input.txt"));
            String str;
            while((str = br.readLine()) != null)
                System.out.println(str);
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
