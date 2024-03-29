import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Student> students = queryStudents();
        students.forEach(System.out::println);

        queryStudents().forEach(System.out::println);
        System.out.println("insert new student...");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO students " +
                            "(name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, "大白");
                ps.setBoolean(2, true);
                ps.setInt(3, 3);
                ps.setInt(4, 97);
                int n = ps.executeUpdate();
                System.out.println(n + " inserted.");
            }
        }

        System.out.println("insert new student and return id...");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            )) {
                ps.setString(1, "老王");
                ps.setBoolean(2, true);
                ps.setInt(3, 3);
                ps.setInt(4, 99);
                int n = ps.executeUpdate();
                long id = 0;
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }
                System.out.println(n + " inserted.id = " + id);
            }
        }

        System.out.println("update student...");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students set score = ? WHERE name = ?")) {
                ps.setInt(1, 99);
                ps.setString(2, "小贝");
                int n = ps.executeUpdate();
                System.out.println(n + " updated.");
            }
        }

        System.out.println("deleted student");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE score < ?")) {
                ps.setInt(1, 80);
                int n = ps.executeUpdate();
                System.out.println(n + " deleted.");
            }
        }
        queryStudents().forEach(System.out::println);
    }

    /*
    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, 3);
                ps.setInt(2, 90);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }
    */

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        var std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }

    static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "root";
    static final String jdbcPassword = "Chi123456";
}
