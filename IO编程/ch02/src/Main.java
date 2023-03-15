import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("hello ".getBytes(StandardCharsets.UTF_8));
            output.write("world!".getBytes(StandardCharsets.UTF_8));
            data = output.toByteArray();
        }
        System.out.println(new String(data, StandardCharsets.UTF_8));
    }
}
