package DOAN;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileInputStream;

public abstract class File {
    protected String bath;
    protected int soluong;

    public File() {
        soluong = 0;
        bath = null;
    }

    public abstract void Parse(String line, int num);

    public abstract String writeline(int i);

    public void docFile() throws IOException {
        try {
            InputStream inputStream = new FileInputStream(bath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            int count = Integer.parseInt(reader.readLine());
            String[] line = new String[count];
            for (int i = 0; i < count; i++) {
                line[i] = reader.readLine();
                Parse(line[i], i);
            }
            soluong = count;
            inputStreamReader.close();
            reader.close();
            inputStream.close();
        } catch (IOException ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

    public void ghiFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(bath);
            fw.write(this.soluong + "\n");
            for (int i = 0; i < this.soluong; i++) {
                fw.write(writeline(i));
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Ghi file that bai");
        }
    }

}

