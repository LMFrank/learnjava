import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        try (Reader reader = new FileReader("D:\\Code\\Java\\learnjava\\IO编程\\ch04\\src\\readme.txt", StandardCharsets.UTF_8)) {
            char[] buffer = new char[100];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }
    }
}
