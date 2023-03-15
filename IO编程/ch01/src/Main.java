import java.io.*;

/*public class Main {
    public static void main(String[] args) throws IOException {
        readFile("D:\\Code\\Java\\learnjava\\IO编程\\ch01\\src\\readme.txt");
    }

    *//*public static void readFile(String fileName) throws IOException {
        InputStream input = new FileInputStream(filename);
        for (;;) {
            int n = input.read();
            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
        input.close();
    }*//*

    *//*public static void readFile(String fileName) throws IOException {
        try (InputStream input = new FileInputStream(fileName)) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        }
    }*//*

    public static void readFile(String fileName) throws IOException {
        try (InputStream input = new FileInputStream(fileName)) {
            byte[] buffer = new byte[10];
            int n;
            while ((n = input.read(buffer)) != -1) {
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}*/

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {
            String s = readAsString(input);
            System.out.println(s);
        }
    }

    public static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }
}
